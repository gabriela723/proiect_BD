package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.AdminRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRoleController {
    private AdminRoleView adminRoleView;

    public void startLogic(String id)
    {
        adminRoleView = new AdminRoleView();
        GUIFrameSinglePointAccess.changePanel(adminRoleView.getMainPanel(), "Policlinici");

        adminRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });
    }
}
