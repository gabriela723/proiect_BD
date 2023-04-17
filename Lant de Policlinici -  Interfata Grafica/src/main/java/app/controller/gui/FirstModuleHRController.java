package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModuleInspector.FirstModuleHRView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FirstModuleHRController {
    private FirstModuleHRView firstModuleHRView;

    public void startLogic(String id)
    {
        firstModuleHRView = new FirstModuleHRView();
        GUIFrameSinglePointAccess.changePanel(firstModuleHRView.getMainPanel(), "Policlinici");

        String sum = null;
        String date = null;

        firstModuleHRView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuHRController menuHRController = new MenuHRController();
                menuHRController.startLogic(id);
            }
        });

        firstModuleHRView.getSearchEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRSearchController hrSearchController = new HRSearchController();
                hrSearchController.startLogic(id);
            }
        });
    }

}
