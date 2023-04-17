package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.RemoveTreatmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RemoveTreatmentController {
    private RemoveTreatmentView removeTreatmentView;

    public void startLogic(String id)
    {
        removeTreatmentView = new RemoveTreatmentView();
        GUIFrameSinglePointAccess.changePanel(removeTreatmentView.getMainPanel(), "Policlinici");

        try{
            String query = "{ call afisareSpecializari() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    removeTreatmentView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        removeTreatmentView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        removeTreatmentView.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
