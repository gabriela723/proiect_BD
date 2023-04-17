package app.view.admin;

import lombok.Getter;

import javax.swing.*;

public class RemoveAccountView {
    @Getter
    private JPanel mainPanel;
    @Getter
    private JTextField textField1;
    @Getter
    private JButton removeButton;
    @Getter
    private JButton backButton;
    @Getter
    private JLabel CNPLabel;
    @Getter
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    @Getter
    private JTextField firstNameField;
}
