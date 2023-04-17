package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.ReceptionistScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class ReceptionistScheduleController {
    private ReceptionistScheduleView receptionistScheduleView;

    public void startLogic(String id)
    {
        receptionistScheduleView = new ReceptionistScheduleView();
        GUIFrameSinglePointAccess.changePanel(receptionistScheduleView.getMainPanel(), "Policlinici");

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    receptionistScheduleView.getComboBox1().addItem(name);
                }
            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        receptionistScheduleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleReceptionistController firstModuleReceptionistController = new FirstModuleReceptionistController();
                firstModuleReceptionistController.startLogic(id);
            }
        });

        receptionistScheduleView.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unit = receptionistScheduleView.getComboBox1().getSelectedItem().toString();

                try{
                    String query = "{ call afisareProgram(?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        stmt.setString(1, unit);
                        rs = stmt.executeQuery();

                        while(rs.next()) {
                            if(Objects.equals(rs.getString("zi"), "Luni")) {
                                receptionistScheduleView.getMondayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getMondayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Marti")) {
                                receptionistScheduleView.getTuesdayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getTuesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Miercuri"))
                            {
                                receptionistScheduleView.getWednesdayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getWednesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Joi")) {
                                receptionistScheduleView.getThursdaysStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getThursdaysEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Vineri"))
                            {
                                receptionistScheduleView.getFridayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getFridayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Sambata")){
                                receptionistScheduleView.getSaturdayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getSaturdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Duminica"))
                            {
                                receptionistScheduleView.getSundayStartValue().setText(rs.getString("oraDeschidere"));
                                receptionistScheduleView.getSundayEndValue().setText(rs.getString("oraInchidere"));
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
