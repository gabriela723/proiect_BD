package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.AddUnitView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddUnitController {
    private AddUnitView addUnitView;

    public void startLogic(String id)
    {
        addUnitView = new AddUnitView();
        GUIFrameSinglePointAccess.changePanel(addUnitView.getMainPanel(), "Policlinici");

        addUnitView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);;
            }
        });

        addUnitView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String unit = addUnitView.getTextField1().getText();

                    String query = "{ call adaugareUnitate(?, ?, ?) }";
                    ResultSet rs;
                    String denumire = addUnitView.getTextField1().getText();
                    String fond = addUnitView.getBudgetField().getText();
                    String address = addUnitView.getAddressField().getText();

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        if(denumire.isEmpty() || fond.isEmpty() || address.isEmpty()){
                            GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                        }
                        else
                        {
                            stmt.setString(1, denumire);
                            stmt.setString(2, address);
                            stmt.setString(3, fond);
                            rs = stmt.executeQuery();

                            addUnitView.getTextField1().setText("");
                            addUnitView.getBudgetField().setText("");
                            addUnitView.getAddressField().setText("");

                            GUIFrameSinglePointAccess.showDialogMessage("Unit added successfully!");
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
