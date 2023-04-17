package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.MenuEconomistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEconomistController {
    private MenuEconomistView menuEconomistView;

    public void startLogic(String id)
    {
        menuEconomistView = new MenuEconomistView();
        GUIFrameSinglePointAccess.changePanel(menuEconomistView.getMainPanel(), "Policlinici");

        menuEconomistView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuEconomistView.getHRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleEconomistController firstModuleEconomistController = new FirstModuleEconomistController();
                firstModuleEconomistController.startLogic(id);
            }
        });

        menuEconomistView.getEconomicButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondModuleController secondModuleController = new SecondModuleController();
                secondModuleController.startLogic(id);
            }
        });
    }
}
