package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterController {
    private RegisterView registerView;

    public void startLogic(String id)
    {
        registerView = new RegisterView();
        GUIFrameSinglePointAccess.changePanel(registerView.getRegisterPanel(), "Policlinici");

        registerView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        registerView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNP = registerView.getCNPField().getText();
                String password = new String(registerView.getPasswordField1().getPassword());
                String firstname = registerView.getFirstNameField().getText();
                String lastname = registerView.getLastNameField().getText();
                String address = registerView.getAddressField().getText();
                String phoneNumber = registerView.getPhoneField().getText();
                String email = registerView.getEmailField().getText();
                String function = registerView.getFunctionField().getText();
                Double IBAN = Double.valueOf(registerView.getIbanField().getText());

                if(CNP.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() ||
                phoneNumber.isEmpty() || email.isEmpty() || function.isEmpty())
                {
                    GUIFrameSinglePointAccess.showDialogMessage("Incorrect format!");
                    registerView.getCNPField().setText("");
                    registerView.getEmailField().setText("");
                    registerView.getPasswordField1().setText("");
                    registerView.getAddressField().setText("");
                    registerView.getFunctionField().setText("");
                    registerView.getIbanField().setText("");
                    registerView.getLastNameField().setText("");
                    registerView.getFirstNameField().setText("");
                    registerView.getPhoneField().setText("");
                }

                try{
                    String query = "{ call adaugareUtilizator(?,?,?,?,?,?,?,?,?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {

                        stmt.setString(1, CNP);
                        stmt.setString(2, password);
                        stmt.setString(3, lastname);
                        stmt.setString(4, firstname);
                        stmt.setString(5, address);
                        stmt.setString(6, phoneNumber);
                        stmt.setString(7, email);
                        stmt.setString(9, function);
                        stmt.setString(8, String.valueOf(IBAN));
                        rs = stmt.executeQuery();

                        registerView.getCNPField().setText("");
                        registerView.getEmailField().setText("");
                        registerView.getPasswordField1().setText("");
                        registerView.getAddressField().setText("");
                        registerView.getFunctionField().setText("");
                        registerView.getIbanField().setText("");
                        registerView.getLastNameField().setText("");
                        registerView.getFirstNameField().setText("");
                        registerView.getPhoneField().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Account created successfully!");
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
