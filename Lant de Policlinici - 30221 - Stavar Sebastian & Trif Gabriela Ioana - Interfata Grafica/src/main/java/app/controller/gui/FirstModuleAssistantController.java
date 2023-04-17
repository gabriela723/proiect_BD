package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.FirstModuleAssistantView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstModuleAssistantController {
    private FirstModuleAssistantView firstModuleAssistantView;
    public void startLogic(String id)
    {
        firstModuleAssistantView = new FirstModuleAssistantView();
        GUIFrameSinglePointAccess.changePanel(firstModuleAssistantView.getMainPanel(), "Policlinici");

        firstModuleAssistantView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAssistantController menuAssistentController = new MenuAssistantController();
                menuAssistentController.startLogic(id);
            }
        });

        firstModuleAssistantView.getViewScheduleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistantScheduleController assistantScheduleController = new AssistantScheduleController();
                assistantScheduleController.startLogic(id);
            }
        });
    }
}
