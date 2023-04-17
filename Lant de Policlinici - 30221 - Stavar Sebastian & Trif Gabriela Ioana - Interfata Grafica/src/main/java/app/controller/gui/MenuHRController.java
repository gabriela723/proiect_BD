package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.MenuHRView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHRController {
    private MenuHRView menuHRView;

    void startLogic(String id)
    {
        menuHRView = new MenuHRView();
        GUIFrameSinglePointAccess.changePanel(menuHRView.getMainPanel(), "Policlinici");

        menuHRView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuHRView.getHRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleHRController firstModuleHRController = new FirstModuleHRController();
                firstModuleHRController.startLogic(id);
            }
        });

        menuHRView.getEconomicButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondModuleController secondModuleController = new SecondModuleController();
                secondModuleController.startLogic(id);
            }
        });
    }
}
