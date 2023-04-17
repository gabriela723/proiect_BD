package app.view.role;

import lombok.Getter;

import javax.swing.*;

public class AdminRoleView {
    @Getter
    private JPanel mainPanel;
    @Getter
    private JTextField CNPField;
    @Getter
    private JTextField functionField;
    @Getter
    private JTextField unitField;
    @Getter
    private JButton assignButton;
    @Getter
    private JButton backButton;
    private JLabel CNPLabel;
    private JLabel functionLabel;
    private JLabel unitLabel;
}
