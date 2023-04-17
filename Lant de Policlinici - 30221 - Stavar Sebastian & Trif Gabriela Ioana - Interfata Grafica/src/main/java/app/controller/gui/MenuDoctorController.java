package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.MenuDoctorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDoctorController {
    private MenuDoctorView menuDoctorView;

    public void startLogic(String id)
    {
        menuDoctorView = new MenuDoctorView();
        GUIFrameSinglePointAccess.changePanel(menuDoctorView.getMainPanel(), "Policlinici");

        menuDoctorView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuDoctorView.getHRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleMedicController firstModuleMedicController = new FirstModuleMedicController();
                firstModuleMedicController.startLogic(id);
            }
        });

        menuDoctorView.getEconomicButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondModuleController secondModuleController = new SecondModuleController();
                secondModuleController.startLogic(id);
            }
        });

        menuDoctorView.getOperationalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TMenuMedicController tMenuMedicController = new TMenuMedicController();
                tMenuMedicController.startLogic(id);
            }
        });
    }
}
