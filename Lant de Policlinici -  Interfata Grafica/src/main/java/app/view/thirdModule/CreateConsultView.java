package app.view.thirdModule;

import lombok.Getter;

import javax.swing.*;

public class CreateConsultView {
    @Getter
    private JButton backButton;
    @Getter
    private JTextField durationField;
    @Getter
    private JComboBox treatmentComboBox;
    @Getter
    private JComboBox patientComboBox;
    @Getter
    private JPanel mainPanel;
    @Getter
    private JButton createButton;
    @Getter
    private JComboBox unitComboBox;
    @Getter
    private JFormattedTextField idPatientField;
    @Getter
    private JTextField medicField;
    @Getter
    private JTextField treatmentField;
    @Getter
    private JButton calculateButton;
}
