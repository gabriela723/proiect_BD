package app.view.role;

import lombok.Getter;

import javax.swing.*;

public class MedicalAssistentRoleView {
    @Getter
    private JPanel mainPanel;
    @Getter
    private JTextField CNPField;
    @Getter
    private JTextField typeField;
    @Getter
    private JTextField rankField;
    @Getter
    private JTextField functionField;
    @Getter
    private JTextField unitField;
    @Getter
    private JButton assignButton;
    @Getter
    private JButton backButton;
}
