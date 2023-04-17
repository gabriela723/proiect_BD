package app.view.admin;

import lombok.Getter;

import javax.swing.*;

public class RegisterView {
    @Getter
    private JTextField CNPField;
    @Getter
    private JPasswordField passwordField1;
    @Getter
    private JTextField lastNameField;
    @Getter
    private JTextField firstNameField;
    @Getter
    private JTextField addressField;
    @Getter
    private JTextField phoneField;
    @Getter
    private JTextField emailField;
    @Getter
    private JTextField ibanField;
    @Getter
    private JButton registerButton;
    @Getter
    private JButton backButton;
    private JLabel cnpLabel;

    private JLabel passwordLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel addressLabel;
    private JLabel phoneNoLabel;
    private JLabel emailLabel;
    private JLabel IBANLabel;
    @Getter
    private JTextField functionField;
    private JLabel functionLabel;
    @Getter
    private JPanel registerPanel;
}
