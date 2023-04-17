package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.RegisterAPatientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterPatientController {
    private RegisterAPatientView registerAPatientView;
    public void startLogic(String id)
    {
        registerAPatientView = new RegisterAPatientView();
        GUIFrameSinglePointAccess.changePanel(registerAPatientView.getMainPanel(), "Policlinici");

        registerAPatientView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdModuleReceptionistController thirdModuleReceptionistController = new ThirdModuleReceptionistController();
                thirdModuleReceptionistController.startLogic(id);
            }
        });

        registerAPatientView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call adaugarePacient(?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try (Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                     CallableStatement s = conn1.prepareCall(q)) {

                    if (registerAPatientView.getLastField().getText().isEmpty() ||
                            registerAPatientView.getFirstField().getText().isEmpty() ||
                            registerAPatientView.getBudgeField().getText().isEmpty()) {
                        GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                    } else {
                        s.setString(1, registerAPatientView.getLastField().getText());
                        s.setString(2, registerAPatientView.getFirstField().getText());
                        s.setString(3, registerAPatientView.getBudgeField().getText());
                        rs = s.executeQuery();
                        GUIFrameSinglePointAccess.showDialogMessage("Added with success!");
                    }

                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
