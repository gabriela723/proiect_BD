package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.TReceptionistReceiptView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ReceiptController {
    private TReceptionistReceiptView tReceptionistReceiptView;
    public void startLogic(String id)
    {
        tReceptionistReceiptView = new TReceptionistReceiptView();
        GUIFrameSinglePointAccess.changePanel(tReceptionistReceiptView.getMainPanel(), "Policlinica");

        tReceptionistReceiptView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdModuleReceptionistController thirdModuleReceptionistController = new ThirdModuleReceptionistController();
                thirdModuleReceptionistController.startLogic(id);
            }
        });

        tReceptionistReceiptView.getReceiptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call adaugareProgramare(?, ?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){

                    if(tReceptionistReceiptView.getConsultationField().getText().isEmpty() ||
                            tReceptionistReceiptView.getTextField1().getText().isEmpty() ||
                            tReceptionistReceiptView.getPatientField().getText().isEmpty()
                    )
                    {
                        GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                    }
                    else
                    {
                        s.setString(1, tReceptionistReceiptView.getConsultationField().getText());
                        s.setString(2, tReceptionistReceiptView.getTextField1().getText());
                        s.setString(3, tReceptionistReceiptView.getPatientField().getText());
                        rs = s.executeQuery();

                        tReceptionistReceiptView.getConsultationField().setText("");
                        tReceptionistReceiptView.getTextField1().setText("");
                        tReceptionistReceiptView.getPatientField().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Added with success!");
                    }

                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
