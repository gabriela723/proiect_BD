package app.view;

import lombok.Getter;

import javax.swing.*;

public class LoginView {
    @Getter
    private JTextField textField1;
    @Getter
    private JPasswordField passwordField1;
    private JLabel cnpLabel;
    @Getter
    private JButton loginButton;
    private JLabel passwordLabel;
    @Getter
    private JPanel detailsPanel;
}
