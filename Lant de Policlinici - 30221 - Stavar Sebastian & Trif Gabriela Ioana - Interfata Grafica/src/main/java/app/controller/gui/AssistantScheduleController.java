package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.AssistantScheduleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class AssistantScheduleController {
    private AssistantScheduleView assistantScheduleView;

    public void startLogic(String id)
    {
        assistantScheduleView = new AssistantScheduleView();
        GUIFrameSinglePointAccess.changePanel(assistantScheduleView.getMainPanel(), "Policlinici");

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    assistantScheduleView.getComboBox1().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        assistantScheduleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleAssistantController firstModuleAssistantController = new FirstModuleAssistantController();
                firstModuleAssistantController.startLogic(id);
            }
        });

        assistantScheduleView.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unit = assistantScheduleView.getComboBox1().getSelectedItem().toString();

                try{
                    String query = "{ call afisareProgram(?) }";
                    ResultSet rs;

                    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                        CallableStatement stmt = conn.prepareCall(query)) {
                        stmt.setString(1, unit);
                        rs = stmt.executeQuery();

                        while(rs.next()) {
                            if(Objects.equals(rs.getString("zi"), "Luni")) {
                                assistantScheduleView.getMondayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getMondayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Marti")) {
                                assistantScheduleView.getTuesdayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getTuesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Miercuri"))
                            {
                                assistantScheduleView.getWednesdayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getWednesdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Joi")) {
                                assistantScheduleView.getThursdaysStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getThursdaysEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Vineri"))
                            {
                                assistantScheduleView.getFridayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getFridayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Sambata")){
                                assistantScheduleView.getSaturdayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getSaturdayEndValue().setText(rs.getString("oraInchidere"));
                            }
                            if(Objects.equals(rs.getString("zi"), "Duminica"))
                            {
                                assistantScheduleView.getSundayStartValue().setText(rs.getString("oraDeschidere"));
                                assistantScheduleView.getSundayEndValue().setText(rs.getString("oraInchidere"));
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
