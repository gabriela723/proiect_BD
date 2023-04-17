package app.controller.gui;

import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.firstModule.AllConsultationsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AllConsultationsController {
    private AllConsultationsView allConsultationsView;
    public void startLogic(String id)
    {
        allConsultationsView = new AllConsultationsView();
        GUIFrameSinglePointAccess.changePanel(allConsultationsView.getMainPanel(), "Policlinica");

        String name = null;
        String firstName = null;
        Date day = null;
        String unit = null;
        Time hourS = null;
        Time hourF = null;

        try{
            String query = "{ call programMedic(?) }";
            ResultSet rs;

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinica", "root", "Katsukatsugod12*");
                CallableStatement stmt = conn.prepareCall(query)) {
                stmt.setString(1, id);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    name = rs.getString(1);
                    firstName = rs.getString(2);
                    day = rs.getDate(3);
                    unit = rs.getString(4);
                    hourS = rs.getTime(5);
                    hourF = rs.getTime(6);

                    allConsultationsView.getComboBox1().addItem(day + " -> " + hourS + " <-> " + hourF + " -> " + unit);
                }

            } catch (SQLException ex) {
                System.out.println("error " + ex.getMessage());
            };
        } catch (RuntimeException ex) {
            System.out.println("error " + ex.getMessage());
        }

        allConsultationsView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstModuleMedicController firstModuleMedicController = new FirstModuleMedicController();
                firstModuleMedicController.startLogic(id);
            }
        });
    }
}
