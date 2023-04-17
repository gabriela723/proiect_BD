package app.view.menu;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

import javax.swing.*;

public class MenuReceptionistView {
    @Getter
    private JPanel mainPanel;
    @Getter
    private JButton HRButton;
    @Getter
    private JButton economicButton;
    @Getter
    private JButton operationalButton;
    @Getter
    private JButton backButton;
}
