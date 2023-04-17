package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.MenuAssistentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAssistantController {
    private MenuAssistentView menuAssistentView;

    void startLogic(String id)
    {
        menuAssistentView = new MenuAssistentView();
        GUIFrameSinglePointAccess.changePanel(menuAssistentView.getMainPanel(), "Policlinici");

        menuAssistentView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuAssistentView.getHRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleAssistantController firstModuleAssistantController = new FirstModuleAssistantController();
                firstModuleAssistantController.startLogic(id);
            }
        });

        menuAssistentView.getEconomic1Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondModuleController secondModuleController = new SecondModuleController();
                secondModuleController.startLogic(id);
            }
        });

        menuAssistentView.getOperationalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TMenuAssistantController tMenuAssistantController = new TMenuAssistantController();
                tMenuAssistantController.startLogic(id);
            }
        });
    }
}
