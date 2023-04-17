package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.FirstModuleEconomistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstModuleEconomistController {
    private FirstModuleEconomistView firstModuleEconomistView;

    public void startLogic(String id)
    {
        firstModuleEconomistView = new FirstModuleEconomistView();
        GUIFrameSinglePointAccess.changePanel(firstModuleEconomistView.getMainPanel(), "Policlinici");

        firstModuleEconomistView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuEconomistController menuEconomistController = new MenuEconomistController();
                menuEconomistController.startLogic(id);
            }
        });

        firstModuleEconomistView.getViewScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EconomistScheduleController economistScheduleController = new EconomistScheduleController();
                economistScheduleController.startLogic(id);
            }
        });
    }
}
