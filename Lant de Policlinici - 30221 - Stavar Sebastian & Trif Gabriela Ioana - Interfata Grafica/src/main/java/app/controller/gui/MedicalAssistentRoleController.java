package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.role.MedicalAssistentRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicalAssistentRoleController {
    private MedicalAssistentRoleView medicalAssistentRoleView;

    public void startLogic(String id)
    {
        medicalAssistentRoleView = new MedicalAssistentRoleView();
        GUIFrameSinglePointAccess.changePanel(medicalAssistentRoleView.getMainPanel(), "Policlinici");

        medicalAssistentRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                    AssignRoleController assignRoleController = new AssignRoleController();
                    assignRoleController.startLogic(id);
            }
        });
    }
}
