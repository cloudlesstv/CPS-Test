import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings implements ActionListener {

    static Boolean boolDarkmode = Boolean.FALSE;

    static JFrame frame = new JFrame();
    static JLabel lblsettings = new JLabel("Einstellungen");
    static JButton btndarkmode = new JButton("Darkmode");

    static JTextField txtCloudKey = new JTextField(10);
    static JButton cmdLogin = new JButton("Login");

    static Font defaultFont = new Font("Comic Sans MS", Font.BOLD, 28);
    static Font buttonFont = new Font("Default", Font.BOLD, 20);
    static JPanel contentPanel = new JPanel(new FlowLayout());


    public Settings() {

        frame.addMouseListener(new ActionEventHandler());
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.setSize(960, 480);
        frame.setMinimumSize(new Dimension(960, 480));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Einstellungen");

        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new GridLayout(0, 2));
        contentPanel.setBounds(5, 5, 5, 5);

        contentPanel.add(lblsettings);
        contentPanel.add(btndarkmode);
        contentPanel.add(txtCloudKey);
        contentPanel.add(cmdLogin);

        contentPanel.setBackground(Colors.Gainsboro);
        btndarkmode.setBackground(Colors.Light_Cyan);
        btndarkmode.setForeground(Colors.Imperial_Red);
        cmdLogin.setBackground(Colors.Light_Cyan);
        cmdLogin.setForeground(Colors.Imperial_Red);
        lblsettings.setForeground(Colors.Charcoal);

        btndarkmode.setFont(buttonFont);
        lblsettings.setFont(defaultFont);

        btndarkmode.addActionListener(this);
        cmdLogin.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btndarkmode) {
            if(GUI.boolDarkmode == false) {
                GUI.boolDarkmode = true;
                GUI.contentPanel.setBackground(Colors.Gunmetal);
                GUI.btnSettings.setBackground(Colors.Bdazzled_Blue);
                GUI.btnclick.setBackground(Colors.Bdazzled_Blue);
                GUI.btnclick.setForeground(Colors.Cultured);
                GUI.lblclicks.setForeground(Colors.Pale_Cerulean);
                GUI.lblcps.setForeground(Colors.Pale_Cerulean);
                GUI.lbllast.setForeground(Colors.Pale_Cerulean);
                GUI.lblHS.setForeground(Colors.Pale_Cerulean);
                Debug.printStacktrace("Enabled Darkmode.");
            }else {
                GUI.boolDarkmode = false;
                GUI.contentPanel.setBackground(Colors.Gainsboro);
                GUI.btnSettings.setBackground(Colors.Light_Cyan);
                GUI.btnclick.setBackground(Colors.Light_Cyan);
                GUI.btnclick.setForeground(Colors.Rich_Black_FOGRA_39);
                GUI.lblclicks.setForeground(Colors.Charcoal);
                GUI.lblcps.setForeground(Colors.Charcoal);
                GUI.lbllast.setForeground(Colors.Charcoal);
                GUI.lblHS.setForeground(Colors.Charcoal);
                Debug.printStacktrace("Disabled Darkmode");
            }
        }else if(e.getSource() == cmdLogin) {
            if(!txtCloudKey.getText().equalsIgnoreCase("")) {
                DatabaseHandler.register(txtCloudKey.getText(), 0);
            }
        }
    }
}
