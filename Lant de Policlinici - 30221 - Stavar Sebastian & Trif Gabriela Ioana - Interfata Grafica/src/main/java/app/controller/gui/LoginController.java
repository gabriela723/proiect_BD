package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class LoginController{
        private LoginView loginView;

        public void startLogic() {
                loginView = new LoginView();
                GUIFrameSinglePointAccess.changePanel(loginView.getDetailsPanel(), "Policlinici");

                loginView.getLoginButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try{
                                        String id = null;
                                        String function = null;
                                        String CNP = loginView.getTextField1().getText().toString();
                                        String password = new String(loginView.getPasswordField1().getPassword());

                                        String query = "{ call login(?,?) }";
                                        String q = "{ call gasireFunctieUtilizator(?) }";
                                        ResultSet rs;
                                        ResultSet rs1;

                                        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                                            CallableStatement stmt = conn.prepareCall(query)) {
                                                stmt.setString(1, CNP);
                                                stmt.setString(2, password);
                                                rs = stmt.executeQuery();

                                                if(rs.next())
                                                {
                                                        id = rs.getString("CNP");
                                                        try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                                                            CallableStatement s = conn.prepareCall(q)){
                                                                s.setString(1, CNP);
                                                                rs1 = s.executeQuery();

                                                                if(rs1.next())
                                                                {
                                                                        function = rs1.getString("functia");
                                                                        if(Objects.equals(function, "administrator") || Objects.equals(function, "super administrator")) {
                                                                                AdminMenuController menuController = new AdminMenuController();
                                                                                menuController.startLogic(id);
                                                                        }
                                                                        else if(Objects.equals(function, "medic"))
                                                                        {
                                                                                MenuDoctorController menuDoctorController = new MenuDoctorController();
                                                                                menuDoctorController.startLogic(id);
                                                                        }
                                                                        else if(Objects.equals(function, "asistent"))
                                                                        {
                                                                                MenuAssistantController menuAssistentController = new MenuAssistantController();
                                                                                menuAssistentController.startLogic(id);
                                                                        }
                                                                        else if(Objects.equals(function, "inspector_resurse_umane"))
                                                                        {
                                                                               MenuHRController menuHRController = new MenuHRController();
                                                                               menuHRController.startLogic(id);
                                                                        }
                                                                        else if(Objects.equals(function, "economist"))
                                                                        {
                                                                                MenuEconomistController menuEconomistController = new MenuEconomistController();
                                                                                menuEconomistController.startLogic(id);
                                                                        }
                                                                        else if(Objects.equals(function, "receptioner"))
                                                                        {
                                                                                MenuReceptionistController menuReceptionistController = new MenuReceptionistController();
                                                                                menuReceptionistController.startLogic(id);
                                                                        }
                                                                }
                                                        }
                                                }
                                                else
                                                {
                                                        GUIFrameSinglePointAccess.showDialogMessage("Invalid CNP or password!");
                                                        loginView.getTextField1().setText("");
                                                        loginView.getPasswordField1().setText("");
                                                }
                                        } catch (SQLException ex) {
                                                System.out.println("error " + ex.getMessage());
                                        };
                                } catch (RuntimeException ex) {
                                        System.out.println("error " + ex.getMessage());
                                }
                        }
                });
        }
}
