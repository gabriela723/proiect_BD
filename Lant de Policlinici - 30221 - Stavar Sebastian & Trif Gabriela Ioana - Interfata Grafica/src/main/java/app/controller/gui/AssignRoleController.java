package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.AssignRoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignRoleController {
    private AssignRoleView assignRoleView;

    public void startLogic(String id)
    {
        assignRoleView = new AssignRoleView();
        GUIFrameSinglePointAccess.changePanel(assignRoleView.getMainPanel(), "Policlinici");

        assignRoleView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenuController adminMenuController = new AdminMenuController();
                adminMenuController.startLogic(id);
            }
        });

        assignRoleView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(assignRoleView.getAdminCheckBox().isSelected())
                {
                    AdminRoleController adminRoleController = new AdminRoleController();
                    adminRoleController.startLogic(id);
                }
                else if(assignRoleView.getMedicCheckBox().isSelected())
                {
                    MedicRoleController medicRoleController = new MedicRoleController();
                    medicRoleController.startLogic(id);
                }
                else if(assignRoleView.getAssistentCheckBox().isSelected())
                {
                    MedicalAssistentRoleController medicalAssistentRoleController = new MedicalAssistentRoleController();
                    medicalAssistentRoleController.startLogic(id);
                }
                else if(assignRoleView.getHRInspectorCheckBox().isSelected())
                {
                    InspectorRoleController inspectorRoleController = new InspectorRoleController();
                    inspectorRoleController.startLogic(id);
                }
                else if(assignRoleView.getReceptionistCheckBox().isSelected())
                {
                    ReceptionistRoleController receptionistRoleController = new ReceptionistRoleController();
                    receptionistRoleController.startLogic(id);
                }
                else if(assignRoleView.getEconomistCheckBox().isSelected())
                {
                    EconomistRoleController economistRoleController = new EconomistRoleController();
                    economistRoleController.startLogic(id);
                }
            }
        });
    }
}
