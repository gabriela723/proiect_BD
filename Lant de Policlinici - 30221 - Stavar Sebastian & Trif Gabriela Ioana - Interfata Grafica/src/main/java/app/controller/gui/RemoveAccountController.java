package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.RemoveAccountView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RemoveAccountController {
    private RemoveAccountView removeAccountView;

    public void startLogic(String id)
    {
        removeAccountView = new RemoveAccountView();
        GUIFrameSinglePointAccess.changePanel(removeAccountView.getMainPanel(), "Policlinici");

        removeAccountView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        removeAccountView.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNP = removeAccountView.getCNPLabel().getText();
                String firstname = removeAccountView.getFirstNameField().getText();
                String lastname = removeAccountView.getLastNameField().getText();

                if(CNP.isEmpty() || firstname.isEmpty() || lastname.isEmpty())
                {
                    GUIFrameSinglePointAccess.showDialogMessage("Incorrect format!");
                    removeAccountView.getLastNameField().setText("");
                    removeAccountView.getLastNameField().setText("");
                    removeAccountView.getTextField1().setText("");
                }

                try{
                    String query = "{ call stergereAngajat(?,?,?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {

                        stmt.setString(1, CNP);
                        stmt.setString(2, lastname);
                        stmt.setString(3, firstname);
                        int row = stmt.executeUpdate();
                        rs = stmt.executeQuery();

                        removeAccountView.getLastNameField().setText("");
                        removeAccountView.getLastNameField().setText("");
                        removeAccountView.getTextField1().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Account removed with success!");
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
