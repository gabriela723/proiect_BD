package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.EconomistRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EconomistRoleController {
    private EconomistRoleView economistRoleView;

    public void startLogic(String id)
    {
        economistRoleView = new EconomistRoleView();
        GUIFrameSinglePointAccess.changePanel(economistRoleView.getMainPanel(), "Policlinici");

        economistRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });
    }
}
