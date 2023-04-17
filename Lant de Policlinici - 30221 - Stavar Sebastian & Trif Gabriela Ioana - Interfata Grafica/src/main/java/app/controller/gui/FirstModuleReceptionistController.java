package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.FirstModuleReceptionistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstModuleReceptionistController {
    private FirstModuleReceptionistView firstModuleReceptionistView;

    public void startLogic(String id)
    {
        firstModuleReceptionistView = new FirstModuleReceptionistView();
        GUIFrameSinglePointAccess.changePanel(firstModuleReceptionistView.getMainPanel(), "Policlinici");

        firstModuleReceptionistView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReceptionistController menuReceptionistController = new MenuReceptionistController();
                menuReceptionistController.startLogic(id);
            }
        });

        firstModuleReceptionistView.getViewScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceptionistScheduleController receptionistScheduleController = new ReceptionistScheduleController();
                receptionistScheduleController.startLogic(id);
            }
        });
    }
}
