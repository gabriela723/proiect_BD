package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.MakeAReportView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class CompleteReportController {
    private MakeAReportView makeAReportView;

    public void startLogic(String id)
    {
        makeAReportView = new MakeAReportView();
        GUIFrameSinglePointAccess.changePanel(makeAReportView.getMainPanel(), "Policlinici");

        makeAReportView.getMedicField().setText(id);

        makeAReportView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call gasireFunctieUtilizator(?) }";
                ResultSet rs1;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){
                    s.setString(1, id);
                    rs1 = s.executeQuery();

                    if(rs1.next())
                    {
                        function = rs1.getString("functia");
                        if(Objects.equals(function, "medic"))
                        {
                            TMenuMedicController menuMedicController = new TMenuMedicController();
                            menuMedicController.startLogic(id);
                        }
                        else if(Objects.equals(function, "asistent"))
                        {
                            TMenuAssistantController tMenuAssistantController = new TMenuAssistantController();
                            tMenuAssistantController.startLogic(id);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });

        makeAReportView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call adaugareRaportMedical(?, ?, ?, ?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){
                    if(makeAReportView.getAssistantField().getText().isEmpty() ||
                            makeAReportView.getConsultationField().getText().isEmpty() ||
                            makeAReportView.getHistoryField().getText().isEmpty() ||
                            makeAReportView.getSymptomField().getText().isEmpty() ||
                            makeAReportView.getDiagnosticField().getText().isEmpty() ||
                            makeAReportView.getRecommendationField().getText().isEmpty()
                    )
                    {
                        GUIFrameSinglePointAccess.showDialogMessage("Invalid!");
                    }
                    else
                    {
                        s.setString(1, makeAReportView.getAssistantField().getText());
                        s.setString(2, makeAReportView.getConsultationField().getText());
                        s.setString(3, makeAReportView.getHistoryField().getText());
                        s.setString(4, makeAReportView.getSymptomField().getText());
                        s.setString(5, makeAReportView.getDiagnosticField().getText());
                        s.setString(6, makeAReportView.getRecommendationField().getText());
                        rs = s.executeQuery();

                        makeAReportView.getAssistantField().setText("");
                        makeAReportView.getConsultationField().setText("");
                        makeAReportView.getHistoryField().setText("");
                        makeAReportView.getSymptomField().setText("");
                        makeAReportView.getDiagnosticField().setText("");
                        makeAReportView.getRecommendationField().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Added with success!");
                    }
                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
