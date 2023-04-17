package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.TMenuMedicView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TMenuMedicController {
    private TMenuMedicView tMenuMedicView;
    public void startLogic(String id)
    {
        tMenuMedicView = new TMenuMedicView();
        GUIFrameSinglePointAccess.changePanel(tMenuMedicView.getMainPanel(), "Policlinici");

        tMenuMedicView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDoctorController menuDoctorController = new MenuDoctorController();
                menuDoctorController.startLogic(id);
            }
        });

        tMenuMedicView.getSealButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SealController sealController = new SealController();
                sealController.startLogic(id);
            }
        });

        tMenuMedicView.getMedicalConsultButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultController consultController = new ConsultController();
                consultController.startLogic(id);
            }
        });

        tMenuMedicView.getSeeAllPatientButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeeAllPatientController seeAllPatientController = new SeeAllPatientController();
                seeAllPatientController.startLogic(id);
            }
        });

        tMenuMedicView.getCompleteAMedicalReportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompleteReportController completeReportController = new CompleteReportController();
                completeReportController.startLogic(id);
            }
        });
    }
}
