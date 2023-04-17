package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.MedicRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicRoleController {
    private MedicRoleView medicRoleView;

    public void startLogic(String id)
    {
        medicRoleView = new MedicRoleView();
        GUIFrameSinglePointAccess.changePanel(medicRoleView.getMainPanel(), "Policlinici");

        medicRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignRoleController assignRoleController = new AssignRoleController();
                assignRoleController.startLogic(id);
            }
        });
    }
}
