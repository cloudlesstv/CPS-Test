import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class GUI {

    static Boolean boolDarkmode = Boolean.FALSE;

    static JFrame frame = new JFrame();
    static JLabel lblclicks = new JLabel("Clicks: " + Main.count, JLabel.LEFT);
    static JLabel lblcps = new JLabel("CPS: " + Main.cps + " C/s", JLabel.RIGHT);
    static JLabel lbllast = new JLabel("Last results: N/A");
    static JLabel lblHS = new JLabel("Highscore: N/A", JLabel.RIGHT);
    static JButton btnclick = new JButton("Click");
    static JButton btnSettings = new JButton("Einstellungen");
    static Font defaultFont = new Font("Comic Sans MS", Font.BOLD, 28);
    static Font buttonFont = new Font("Default", Font.BOLD, 20);
    static JPanel contentPanel = new JPanel(new FlowLayout());


    public GUI() {

        frame.addMouseListener(new ActionEventHandler());
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.setSize(960, 480);
        frame.setMinimumSize(new Dimension(960, 480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CPS-Test by CloudLessTv");

        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new GridLayout(0, 2));
        contentPanel.setBounds(5, 5, 5, 5);

        contentPanel.add(lblclicks);
        contentPanel.add(lblcps);
        contentPanel.add(btnclick);
        contentPanel.add(btnSettings);
        contentPanel.add(lbllast);
        contentPanel.add(lblHS);

        contentPanel.setBackground(Colors.Gainsboro);
        btnSettings.setBackground(Colors.Light_Cyan);
        btnclick.setBackground(Colors.Light_Cyan);
        btnSettings.setForeground(Colors.Imperial_Red);
        btnclick.setForeground(Colors.Rich_Black_FOGRA_39);
        lblclicks.setForeground(Colors.Charcoal);
        lblcps.setForeground(Colors.Charcoal);
        lbllast.setForeground(Colors.Charcoal);
        lblHS.setForeground(Colors.Charcoal);

        btnclick.setFont(buttonFont);
        btnSettings.setFont(buttonFont);
        lblcps.setFont(defaultFont);
        lblclicks.setFont(defaultFont);
        lbllast.setFont(defaultFont);
        lblHS.setFont(defaultFont);

        btnclick.addActionListener(new ActionEventHandler());
        btnSettings.addActionListener(new ActionEventHandler());

                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String s = scanner.next();
                    if (s.equalsIgnoreCase("Clicks.double")) {
                        if (Main.boolDouble == false) {
                            System.out.println(Main.debug + "Clicks will be doubled from now");
                            Main.boolDouble = true;
                        } else {
                            System.out.println(Main.debug + "Clicks will not be doubled from now");
                            Main.boolDouble = false;
                        }
                    } else if (s.equalsIgnoreCase("Clicks.reset")) {
                        Main.cps = 0;
                        Main.hcps = 0;
                        Main.count = 0;

                        lblclicks.setText("Clicks: " + Main.count);
                        lblHS.setText("Highscore: N/A");

                        System.out.println(Main.debug + "Stats resetted.");
                        RPC.update();
                    } else if (s.equalsIgnoreCase("Clicks.clearlast")) {
                        Main.stats.clear();

                        lbllast.setText("Last results: N/A");

                        System.out.println(Main.debug + "History cleared.");

                    } else {
                        System.out.println(Main.debug + "Command not found.");
                    }
                }
            }
        }
