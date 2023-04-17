package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.secondModule.SecondModuleHRView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class SecondModuleController {
    private SecondModuleHRView secondModuleHRView;
    public void startLogic(String id)
    {
        secondModuleHRView = new SecondModuleHRView();
        GUIFrameSinglePointAccess.changePanel(secondModuleHRView.getMainPanel(), "Policlinici");

        String sum = null;
        String date = null;

        try{
            String query = "{ call afisareSalarii(?) }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {
                stmt.setString(1, id);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    sum = rs.getString("suma");
                    date = rs.getString("luna");

                    secondModuleHRView.getComboBox1().addItem(date + " -> " + sum);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        secondModuleHRView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call gasireFunctieUtilizator(?) }";
                ResultSet rs1;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){
                    s.setString(1, id);
                    rs1 = s.executeQuery();

                    if(rs1.next())
                    {
                        function = rs1.getString("functia");
                        if(Objects.equals(function, "medic"))
                        {
                            MenuDoctorController menuDoctorController = new MenuDoctorController();
                            menuDoctorController.startLogic(id);
                        }
                        else if(Objects.equals(function, "asistent"))
                        {
                            MenuAssistantController menuAssistantController = new MenuAssistantController();
                            menuAssistantController.startLogic(id);
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
                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }

            }
        });
    }
}
