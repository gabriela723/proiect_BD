package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.SealView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class SealController {
    private SealView sealView;

    public void startLogic(String id)
    {
        sealView = new SealView();
        GUIFrameSinglePointAccess.changePanel(sealView.getMainPanel(), "Policlinici");

        String idR = null;
        try{
            String query = "{ call afisareRapoarte() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    idR = rs.getString(1);
                    sealView.getReportComboBox().addItem(idR);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        sealView.getBackButton().addActionListener(new ActionListener() {
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
                            TMenuMedicController tMenuMedicController = new TMenuMedicController();
                            tMenuMedicController.startLogic(id);
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

        sealView.getSealButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call parafareRaport(?, ?) }";
                ResultSet rs1;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){
                    s.setString(1, sealView.getReportComboBox().getSelectedItem().toString());
                    s.setString(2, id);
                    rs1 = s.executeQuery();

                    GUIFrameSinglePointAccess.showDialogMessage("Sealed with success!");


                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
