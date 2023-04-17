package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.ReceptionistRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistRoleController {
    private ReceptionistRoleView receptionistRoleView;

    public void startLogic(String id)
    {
        receptionistRoleView = new ReceptionistRoleView();
        GUIFrameSinglePointAccess.changePanel(receptionistRoleView.getMainPanel(), "PoliclinicI");

        receptionistRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });
    }
}
