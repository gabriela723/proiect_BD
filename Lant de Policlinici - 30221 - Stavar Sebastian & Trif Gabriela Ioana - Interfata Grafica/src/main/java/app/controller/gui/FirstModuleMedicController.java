package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.FirstModuleMedicView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstModuleMedicController {
    private FirstModuleMedicView firstModuleMedicView;

    public void startLogic(String id)
    {
        firstModuleMedicView = new FirstModuleMedicView();
        GUIFrameSinglePointAccess.changePanel(firstModuleMedicView.getMainPanel(), "Policlinici");

        firstModuleMedicView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDoctorController menuDoctorController = new MenuDoctorController();
                menuDoctorController.startLogic(id);
            }
        });

        firstModuleMedicView.getViewScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicScheduleController medicScheduleController = new MedicScheduleController();
                medicScheduleController.startLogic(id);
            }
        });

        firstModuleMedicView.getViewConsultationsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllConsultationsController allConsultationsController = new AllConsultationsController();
                allConsultationsController.startLogic(id);
            }
        });
    }
}
