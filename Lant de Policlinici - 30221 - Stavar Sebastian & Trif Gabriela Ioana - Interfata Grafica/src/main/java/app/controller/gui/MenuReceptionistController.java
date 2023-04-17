package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.MenuReceptionistView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuReceptionistController {
    private MenuReceptionistView menuReceptionistView;

    public void startLogic(String id)
    {
        menuReceptionistView = new MenuReceptionistView();
        GUIFrameSinglePointAccess.changePanel(menuReceptionistView.getMainPanel(), "Policlini");

        menuReceptionistView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuReceptionistView.getHRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleReceptionistController firstModuleReceptionistController = new FirstModuleReceptionistController();
                firstModuleReceptionistController.startLogic(id);
            }
        });

        menuReceptionistView.getEconomicButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondModuleController secondModuleController = new SecondModuleController();
                secondModuleController.startLogic(id);
            }
        });

        menuReceptionistView.getOperationalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdModuleReceptionistController thirdModuleReceptionistController = new ThirdModuleReceptionistController();
                thirdModuleReceptionistController.startLogic(id);
            }
        });
    }
}
