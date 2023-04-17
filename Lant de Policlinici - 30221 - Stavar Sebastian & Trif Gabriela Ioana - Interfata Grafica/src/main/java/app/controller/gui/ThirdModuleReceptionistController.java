package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.TMenuReceptionistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdModuleReceptionistController {
    private TMenuReceptionistView tMenuReceptionistView;
    public void startLogic(String id)
    {
        tMenuReceptionistView = new TMenuReceptionistView();
        GUIFrameSinglePointAccess.changePanel(tMenuReceptionistView.getMainPanel(), "Policlinica");

        tMenuReceptionistView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReceptionistController menuReceptionistController = new MenuReceptionistController();
                menuReceptionistController.startLogic(id);
            }
        });

        tMenuReceptionistView.getReceiptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceiptController receiptController = new ReceiptController();
                receiptController.startLogic(id);
            }
        });

        tMenuReceptionistView.getRegisterAPatientButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPatientController registerPatientController = new RegisterPatientController();
                registerPatientController.startLogic(id);
            }
        });

        tMenuReceptionistView.getScheduleAnAppoitmentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScheduleAnAppointmentController scheduleAnAppointmentController = new ScheduleAnAppointmentController();
                scheduleAnAppointmentController.startLogic(id);
            }
        });
    }

}
