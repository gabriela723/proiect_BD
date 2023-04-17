package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.TMakeAnAppointmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ScheduleAnAppointmentController {
    private TMakeAnAppointmentView tMakeAnAppointmentView;
    public void startLogic(String id)
    {
        tMakeAnAppointmentView = new TMakeAnAppointmentView();
        GUIFrameSinglePointAccess.changePanel(tMakeAnAppointmentView.getMainPanel(), "Policlinici");

        tMakeAnAppointmentView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdModuleReceptionistController thirdModuleReceptionistController = new ThirdModuleReceptionistController();
                thirdModuleReceptionistController.startLogic(id);
            }
        });

        tMakeAnAppointmentView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call adaugareProgramare(?, ?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){
                    s.setString(1, tMakeAnAppointmentView.getIdField().getText());
                    s.setString(2, tMakeAnAppointmentView.getUnitField().getText());
                    s.setString(3, tMakeAnAppointmentView.getDayField().getText());
                    s.setString(4, tMakeAnAppointmentView.getHourField().getText());


                    if(tMakeAnAppointmentView.getIdField().getText().isEmpty() ||
                            tMakeAnAppointmentView.getUnitField().getText().isEmpty() ||
                            tMakeAnAppointmentView.getDayField().getText().isEmpty() ||
                            tMakeAnAppointmentView.getHourField().getText().isEmpty()
                    )
                    {
                        GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                    }
                    else
                    {
                        rs = s.executeQuery();
                        tMakeAnAppointmentView.getIdField().setText("");
                        tMakeAnAppointmentView.getUnitField().setText("");
                        tMakeAnAppointmentView.getDayField().setText("");
                        tMakeAnAppointmentView.getHourField().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Added with success!");
                    }

                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
