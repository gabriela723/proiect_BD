package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.RemoveUnitView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RemoveUnitController {
    private RemoveUnitView removeUnitView;

    public void startLogic(String id)
    {
        removeUnitView = new RemoveUnitView();
        GUIFrameSinglePointAccess.changePanel(removeUnitView.getMainPanel(), "Policlinici");

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    removeUnitView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        removeUnitView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        removeUnitView.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String unit = removeUnitView.getComboBox1().getSelectedItem().toString();

                    String query = "{ call stergereUnitate(?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        stmt.setString(1, unit);
                        rs = stmt.executeQuery();

                        GUIFrameSinglePointAccess.showDialogMessage("Unit removed successfully!");
                        RemoveUnitController removeUnitController = new RemoveUnitController();
                        removeUnitController.startLogic(id);

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
