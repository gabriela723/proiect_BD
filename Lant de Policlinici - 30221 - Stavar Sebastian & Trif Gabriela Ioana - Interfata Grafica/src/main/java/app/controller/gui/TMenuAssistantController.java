package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.TMenuAssitentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TMenuAssistantController {
    private TMenuAssitentView tMenuAssitantView;
    public void startLogic(String id)
    {
        tMenuAssitantView = new TMenuAssitentView();
        GUIFrameSinglePointAccess.changePanel(tMenuAssitantView.getMainPanel(), "Policlinici");

        tMenuAssitantView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAssistantController menuAssistantController = new MenuAssistantController();
                menuAssistantController.startLogic(id);
            }
        });

        tMenuAssitantView.getSealButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SealController sealController = new SealController();
                sealController.startLogic(id);
            }
        });

        tMenuAssitantView.getCompleteAMedicalReportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompleteReportController completeReportController = new CompleteReportController();
                completeReportController.startLogic(id);
            }
        });

        tMenuAssitantView.getSeeAllPatientButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeeAllPatientController seeAllPatientController = new SeeAllPatientController();
                seeAllPatientController.startLogic(id);
            }
        });
    }
}
