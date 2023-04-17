package app.controller.gui;

import app.model.Consultatie;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.thirdModule.CreateConsultView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class ConsultController {
    private CreateConsultView createConsultView;
    public void startLogic(String id)
    {
        createConsultView = new CreateConsultView();
        GUIFrameSinglePointAccess.changePanel(createConsultView.getMainPanel(), "Policlinici");

        String CNP = null;
        String firstName = null;
        String lastName = null;
        Integer idP = null;
        String idMedic = null;
        Integer idTreatment = null;
        String unit = null;

        createConsultView.getMedicField().setText(id);

        try{
            String query = "{ call afisareSpecializari() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    idTreatment = Integer.valueOf(rs.getString(2));

                    createConsultView.getTreatmentComboBox().addItem(idTreatment + ". " + name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

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

                    createConsultView.getPatientComboBox().addItem(idP + ". " + lastName + " " + firstName);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        try{
            String query = "{ call afisareUnitati() }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {

                rs = stmt.executeQuery();
                while(rs.next())
                {
                    String name = rs.getString(1);
                    unit = name;
                    createConsultView.getUnitComboBox().addItem(name);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        createConsultView.getBackButton().addActionListener(new ActionListener() {
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

        Consultatie consultatie = new Consultatie();
        createConsultView.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call adaugareConsultatie(?, ?, ?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){

                    s.setString(1, createConsultView.getDurationField().getText());
                    s.setString(2, createConsultView.getMedicField().getText());
                    s.setString(3, createConsultView.getTreatmentField().getText());
                    s.setString(4, createConsultView.getIdPatientField().getText());
                    s.setString(5, createConsultView.getUnitComboBox().getSelectedItem().toString());
                    rs = s.executeQuery();

                    consultatie.setDurata(Time.valueOf(createConsultView.getDurationField().getText()));
                    consultatie.setIdMedic(id);
                    consultatie.setIdSpecializare(createConsultView.getTreatmentField().getText());
                    consultatie.setIdPacient(createConsultView.getIdPatientField().getText());

                    GUIFrameSinglePointAccess.showDialogMessage("Added with success!");

                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });

        createConsultView.getCalculateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "{ call costConsultatie(?, ?, ?) }";
                ResultSet rs;
                String function = null;
                try(Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                    CallableStatement s = conn1.prepareCall(q)){

                    Integer idC = null;
                    Time aux = Time.valueOf(createConsultView.getDurationField().getText());
                    if(consultatie.getDurata().equals(aux)
                    && consultatie.getIdPacient().equals(createConsultView.getIdPatientField().getText())
                    && consultatie.getIdMedic().equals(id)
                    && consultatie.getIdSpecializare().equals(createConsultView.getTreatmentField().getText()))
                    {
                        s.setString(1, String.valueOf(consultatie.getIdConsultatie()));
                    }

                    s.setString(2, createConsultView.getMedicField().getText());
                    s.setString(3, createConsultView.getTreatmentField().getText());
                    rs = s.executeQuery();

                    GUIFrameSinglePointAccess.showDialogMessage("Added with success!");

                } catch (SQLException ex) {
                    System.out.println("error " + ex.getMessage());
                }
            }
        });
    }
}
