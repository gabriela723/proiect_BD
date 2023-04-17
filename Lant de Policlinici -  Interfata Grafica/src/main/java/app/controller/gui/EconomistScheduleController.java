package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.EconomistScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class EconomistScheduleController {
    private EconomistScheduleView economistScheduleView;

    public void startLogic(String id)
    {
        economistScheduleView = new EconomistScheduleView();
        GUIFrameSinglePointAccess.changePanel(economistScheduleView.getMainPanel(), "Policlinica");

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    economistScheduleView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        economistScheduleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleEconomistController firstModuleEconomistController = new FirstModuleEconomistController();
                firstModuleEconomistController.startLogic(id);
            }
        });

        economistScheduleView.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unit = economistScheduleView.getComboBox1().getSelectedItem().toString();

                try{
                    String query = "{ call afisareProgram(?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        stmt.setString(1, unit);
                        rs = stmt.executeQuery();

                        while(rs.next()) {
                            if(Objects.equals(rs.getString("zi"), "Luni")) {
                                economistScheduleView.getMondayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getMondayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Marti")) {
                                economistScheduleView.getTuesdayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getTuesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Miercuri"))
                            {
                                economistScheduleView.getWednesdayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getWednesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Joi")) {
                                economistScheduleView.getThursdaysStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getThursdaysEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Vineri"))
                            {
                                economistScheduleView.getFridayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getFridayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Sambata")){
                                economistScheduleView.getSaturdayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getSaturdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Duminica"))
                            {
                                economistScheduleView.getSundayStartValue().setText(rs.getString("oraDeschidere"));
                                economistScheduleView.getSundayEndValue().setText(rs.getString("oraInchidere"));
                            }
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
