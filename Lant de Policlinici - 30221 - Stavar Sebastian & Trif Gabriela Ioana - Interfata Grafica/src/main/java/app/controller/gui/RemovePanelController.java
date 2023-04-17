package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.admin.RemoveAccountView;

public class RemovePanelController {
    private RemoveAccountView removeAccountView;

    public void startLogic(String id)
    {
        removeAccountView = new RemoveAccountView();
        GUIFrameSinglePointAccess.changePanel(removeAccountView.getMainPanel(), "Policlinici");
    }
}
