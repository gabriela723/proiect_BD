package app;

import app.controller.gui.LoginController;

import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.startLogic();
    }
}
