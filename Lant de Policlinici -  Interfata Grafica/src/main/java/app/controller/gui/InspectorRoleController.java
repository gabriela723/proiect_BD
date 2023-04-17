package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.InspectorRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InspectorRoleController {
    private InspectorRoleView insperctorRoleView;

    public void startLogic(String id)
    {
        insperctorRoleView = new InspectorRoleView();
        GUIFrameSinglePointAccess.changePanel(insperctorRoleView.getMainPanel(), "Policlinici");

        insperctorRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });
    }
}
