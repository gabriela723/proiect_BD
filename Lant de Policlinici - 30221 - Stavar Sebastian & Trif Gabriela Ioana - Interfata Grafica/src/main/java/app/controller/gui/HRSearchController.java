package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModuleInspector.HRSearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HRSearchController {
    private HRSearchView hrSearchView;

    public void startLogic(String id)
    {
        hrSearchView = new HRSearchView();
        GUIFrameSinglePointAccess.changePanel(hrSearchView.getMainPanel(), "Policlinici");

        try{
            String query = "call utilizatori()";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    hrSearchView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        hrSearchView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleHRController firstModuleHRController = new FirstModuleHRController();
                firstModuleHRController.startLogic(id);
            }
        });

        hrSearchView.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrSearchView.getMondayStartField().setText("08:00:00");
                hrSearchView.getMondayEndField().setText("16:00:00");

                hrSearchView.getTuesdayStartField().setText("08:00:00");
                hrSearchView.getTuesdayEndField().setText("16:00:00");

                hrSearchView.getWednesdayStartField().setText("08:00:00");
                hrSearchView.getWednesdayEndField().setText("16:00:00");

                hrSearchView.getThursdayStartField().setText("08:00:00");
                hrSearchView.getThursdayEndField().setText("16:00:00");

                hrSearchView.getFridayStartField().setText("08:00:00");
                hrSearchView.getFridayEndField().setText("16:00:00");

                hrSearchView.getSaturdayStartField().setText("10:00:00");
                hrSearchView.getSaturdayEndField().setText("16:00:00");

                hrSearchView.getSundayStartField().setText("10:00:00");
                hrSearchView.getSundayEndField().setText("16:00:00");

                hrSearchView.getVacationStartField().setText("-");
                hrSearchView.getVacationEndField().setText("-");
            }
        });

        hrSearchView.getModifyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrSearchView.getMondayStartField().setText("");
                hrSearchView.getMondayEndField().setText("");

                hrSearchView.getTuesdayStartField().setText("");
                hrSearchView.getTuesdayEndField().setText("");

                hrSearchView.getWednesdayStartField().setText("");
                hrSearchView.getWednesdayEndField().setText("");

                hrSearchView.getThursdayStartField().setText("");
                hrSearchView.getThursdayEndField().setText("");

                hrSearchView.getFridayStartField().setText("");
                hrSearchView.getFridayEndField().setText("");

                hrSearchView.getSaturdayStartField().setText("");
                hrSearchView.getSaturdayEndField().setText("");

                hrSearchView.getSundayStartField().setText("");
                hrSearchView.getSundayEndField().setText("");

                hrSearchView.getVacationStartField().setText("");
                hrSearchView.getVacationEndField().setText("");
            }
        });
    }
}
