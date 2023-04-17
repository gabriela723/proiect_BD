package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.menu.AdminMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuController {
    private AdminMenuView menuView;

    public void startLogic(String id)
    {
        menuView = new AdminMenuView();
        GUIFrameSinglePointAccess.changePanel(menuView.getMenuPanel(), "Policlinici");

        menuView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterController registerController = new RegisterController();
                registerController.startLogic(id);
            }
        });

        menuView.getRemoveUserButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveAccountController removeAccountController = new RemoveAccountController();
                removeAccountController.startLogic(id);
            }
        });

        menuView.getAddTreatmentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTreatmentController addTreatmentController = new AddTreatmentController();
                addTreatmentController.startLogic(id);
            }
        });

        menuView.getRemoveTreatmentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveTreatmentController removeTreatmentController = new RemoveTreatmentController();
                removeTreatmentController.startLogic(id);
            }
        });

        menuView.getAddUnitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUnitController addUnitController = new AddUnitController();
                addUnitController.startLogic(id);
            }
        });

        menuView.getAccountRoleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });

        menuView.getRemoveUnitButton().addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveUnitController removeUnitController = new RemoveUnitController();
                removeUnitController.startLogic(id);
            }
        }));
    }
}
