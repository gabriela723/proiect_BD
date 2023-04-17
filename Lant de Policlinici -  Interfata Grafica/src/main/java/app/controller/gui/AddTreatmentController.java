package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.AddTreatmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddTreatmentController {
    private AddTreatmentView addTreatmentView;

    public void startLogic(String id)
    {
        addTreatmentView = new AddTreatmentView();
        GUIFrameSinglePointAccess.changePanel(addTreatmentView.getMainPanel(), "Policlinici");

        addTreatmentView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        addTreatmentView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String treat = addTreatmentView.getTextField1().getText();
                    Double price = Double.valueOf(addTreatmentView.getTextField2().getText());

                    String query = "{ call adaugareServiciuMedical1(?, ?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        if(treat.isEmpty() || price == null)
                        {
                            GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                            addTreatmentView.getTextField1().setText("");
                            addTreatmentView.getTextField2().setText("");
                        }
                        else
                        {
                            stmt.setString(1, treat);
                            stmt.setDouble(2, price);
                            rs = stmt.executeQuery();

                            GUIFrameSinglePointAccess.showDialogMessage("Treatment added successfully!");
                            addTreatmentView.getTextField1().setText("");
                            addTreatmentView.getTextField2().setText("");
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
