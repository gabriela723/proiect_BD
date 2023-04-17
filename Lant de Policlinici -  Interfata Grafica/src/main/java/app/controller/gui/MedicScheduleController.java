package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.MedicScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class MedicScheduleController {
    private MedicScheduleView medicScheduleView;

    public void startLogic(String id)
    {
        medicScheduleView = new MedicScheduleView();
        GUIFrameSinglePointAccess.changePanel(medicScheduleView.getMainPanel(), "Policlinici");

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    medicScheduleView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }


        medicScheduleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleMedicController firstModuleMedicController = new FirstModuleMedicController();
                firstModuleMedicController.startLogic(id);
            }
        });

        medicScheduleView.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unit = medicScheduleView.getComboBox1().getSelectedItem().toString();

                try{
                    String query = "{ call afisareProgram(?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        stmt.setString(1, unit);
                        rs = stmt.executeQuery();

                        while(rs.next()) {
                            if(Objects.equals(rs.getString("zi"), "Luni")) {
                                medicScheduleView.getMondayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getMondayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Marti")) {
                                medicScheduleView.getTuesdayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getTuesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Miercuri"))
                            {
                                medicScheduleView.getWednesdayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getWednesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Joi")) {
                                medicScheduleView.getThursdaysStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getThursdaysEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Vineri"))
                            {
                                medicScheduleView.getFridayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getFridayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Sambata")){
                                medicScheduleView.getSaturdayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getSaturdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Duminica"))
                            {
                                medicScheduleView.getSundayStartValue().setText(rs.getString("oraDeschidere"));
                                medicScheduleView.getSundayEndValue().setText(rs.getString("oraInchidere"));
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
