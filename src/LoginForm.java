import javax.swing.*;
import java.awt.*;

public class LoginForm {

    static JFrame loginFrame = new JFrame();
    static JPanel loginForm = new JPanel();

    static JLabel head = new JLabel("CPS-Test | CloudKey");
    static JLabel outError = new JLabel("");
    static JLabel pleaseLogin = new JLabel("Please enter your CloudKey, or register.");
    static JPasswordField inCloudKey = new JPasswordField(20);
    static JButton btnLogin = new JButton("Login");
    static JButton btnRegister = new JButton("Register");

    public static void GUI() {
        loginFrame.setContentPane(loginForm);
        loginFrame.setVisible(true);
        loginFrame.setTitle("CPS-Test | Cloudkey");
        loginFrame.setSize(840, 500);

        loginForm.setLayout(new GridLayout(0, 1));
        loginForm.add(head);
        loginForm.add(outError);
        loginForm.add(pleaseLogin);
        loginForm.add(inCloudKey);
        loginForm.add(btnLogin);
        loginForm.add(btnRegister);
        loginForm.setBackground(Colors.Gunmetal);
        head.setFont(GUI.defaultFont);
        head.setForeground(Colors.Cultured);
        inCloudKey.setBackground(Colors.Charcoal);
        inCloudKey.setForeground(Colors.Cultured);
        inCloudKey.setFont(GUI.defaultFont);
        pleaseLogin.setFont(GUI.defaultFont);
        pleaseLogin.setForeground(Colors.Cultured);
        btnLogin.setFont(GUI.buttonFont);
        btnLogin.setForeground(Colors.Cultured);
        btnLogin.setBackground(Colors.Rich_Black_FOGRA_39);
        btnRegister.setFont(GUI.buttonFont);
        btnRegister.setForeground(Colors.Cultured);
        btnRegister.setBackground(Colors.Rich_Black_FOGRA_39);

        btnLogin.addActionListener(new LoginEvent());
        btnLogin.addActionListener(new LoginEvent());
    }
}
