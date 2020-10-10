import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class GUI {

    static Boolean boolDarkmode = Boolean.FALSE;

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel lblclicks = new JLabel("Clicks: " + test.count, JLabel.LEFT);
    static JLabel lblcps = new JLabel("CPS: " + test.cps + " C/s", JLabel.RIGHT);
    static JLabel lbllast = new JLabel("Last results: N/A");
    static JLabel lblHS = new JLabel("Highscore: N/A", JLabel.RIGHT);
    static JButton btnclick = new JButton("Click");
    static JButton btndarkmode = new JButton("Darkmode");
    static Font defaultFont = new Font("Comic Sans MS", Font.BOLD, 28);
    static Font buttonFont = new Font("Default", Font.BOLD, 20);

    public GUI() {
        frame.setVisible(true);
        frame.setSize(960, 480);
        frame.setMinimumSize(new Dimension(960, 480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CPS-Test by CloudLessTv");

        panel.setBorder(BorderFactory.createEmptyBorder(30 , 30, 30, 30));
        panel.setLayout(new GridLayout(3, 0));

        frame.add(panel, BorderLayout.CENTER);

        panel.add(lblclicks);
        panel.add(lblcps);
        panel.add(btnclick);
        panel.add(btndarkmode);
        panel.add(lbllast);
        panel.add(lblHS);

        panel.setBackground(colorPalette.Gainsboro);
        btndarkmode.setBackground(colorPalette.Light_Cyan);
        btnclick.setBackground(colorPalette.Light_Cyan);
        btndarkmode.setForeground(colorPalette.Imperial_Red);
        btnclick.setForeground(colorPalette.Rich_Black_FOGRA_39);
        lblclicks.setForeground(colorPalette.Charcoal);
        lblcps.setForeground(colorPalette.Charcoal);
        lbllast.setForeground(colorPalette.Charcoal);
        lblHS.setForeground(colorPalette.Charcoal);

        btnclick.setFont(buttonFont);
        btndarkmode.setFont(buttonFont);
        lblcps.setFont(defaultFont);
        lblclicks.setFont(defaultFont);
        lbllast.setFont(defaultFont);
        lblHS.setFont(defaultFont);

        btnclick.addActionListener(new ActionEventHandler());
        btndarkmode.addActionListener(new ActionEventHandler());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.next();
            if(s.equalsIgnoreCase("Clicks.double")) {
                if(test.boolDouble == false) {
                    System.out.println(test.debug + "Clicks will be doubled from now");
                    test.boolDouble = true;
                }else {
                    System.out.println(test.debug + "Clicks will not be doubled from now");
                    test.boolDouble = false;
                }
            }else if(s.equalsIgnoreCase("Clicks.reset")) {
                test.cps = 0;
                test.hcps = 0;
                test.count = 0;

                lblclicks.setText("Clicks: " + test.count);
                lblHS.setText("Highscore: N/A");

                System.out.println(test.debug + "Stats resetted.");
            }else if(s.equalsIgnoreCase("Clicks.clearlast")) {
                test.stats.clear();

                lbllast.setText("Last results: N/A");

                System.out.println(test.debug + "History cleared.");

            }else {
                System.out.println(test.debug + "Command not found.");
            }
        }
    }
}
