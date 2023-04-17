package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.SeePatientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class SeeAllPatientController {
    private SeePatientView seePatientView;
    public void startLogic(String id)
    {
        seePatientView = new SeePatientView();
        GUIFrameSinglePointAccess.changePanel(seePatientView.getMainPanel(), "Policlinica");

        String firstName = null;
        String lastName = null;
        Integer idP = null;

        try{
            String query = "{ call pacienti() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    idP = Integer.valueOf(rs.getString(1));
                    lastName = rs.getString(2);
                    firstName = rs.getString(3);

                    seePatientView.getIdComboBox().addItem(idP + ". " + lastName + " " + firstName);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        seePatientView.getBackButton().addActionListener(new ActionListener() {
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


    }
}
