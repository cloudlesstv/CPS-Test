import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static java.awt.Font.ITALIC;

public class GUI implements ActionListener {

    int count;
    int cps;
    int hcps;

    public ArrayList<Integer> stats = new ArrayList<Integer>();

    Boolean boolDarkmode = Boolean.FALSE;
    Boolean boolDouble = Boolean.FALSE;

    JPopupMenu menu = new JPopupMenu();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblclicks = new JLabel("Clicks: " + count);
    JLabel lblcps = new JLabel("CPS: " + cps + " C/s");
    JLabel lbllast = new JLabel("Last results: N/A");
    JLabel lblHS = new JLabel("Highscore: N/A");
    JButton btnclick = new JButton("Click");
    JButton btndarkmode = new JButton("Darkmode");


    Timer sec = new Timer(1000, this);

    public GUI() {
        frame.setVisible(true);
        frame.setSize(180, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.add(lblclicks);
        panel.add(lblcps);
        panel.add(btnclick);
        panel.add(btndarkmode);
        panel.add(lbllast);
        panel.add(lblHS);

        panel.setBackground(Color.WHITE);
        btndarkmode.setBackground(Color.WHITE);
        btnclick.setBackground(Color.WHITE);
        btndarkmode.setForeground(Color.RED);
        btnclick.setForeground(Color.BLACK);
        lblclicks.setForeground(Color.BLACK);
        lblcps.setForeground(Color.BLACK);
        lbllast.setForeground(Color.BLACK);
        lblHS.setForeground(Color.BLACK);

        btnclick.addActionListener(this);
        btndarkmode.addActionListener(this);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.next();
            if(s.equalsIgnoreCase("Clicks.double")) {
                if(boolDouble == false) {
                    System.out.println(test.debug + "Clicks will be doubled from now");
                    boolDouble = true;
                }else {
                    System.out.println(test.debug + "Clicks will not be doubled from now");
                    boolDouble = false;
                }
            }else if(s.equalsIgnoreCase("Clicks.reset")) {
                cps = 0;
                hcps = 0;
                count = 0;

                lblclicks.setText("Clicks: " + count);
                lblHS.setText("Highscore: N/A");

                System.out.println(test.debug + "Stats resetted.");
            }else if(s.equalsIgnoreCase("Clicks.clearlast")) {
                stats.clear();

                lbllast.setText("Last results: N/A");

                System.out.println(test.debug + "History cleared.");
            }else {
                System.out.println(test.debug + "Command not found.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnclick) {
            if(!sec.isRunning()) {
                sec.start();
                System.out.println(test.debug + "Timer Started");
            }
            cps++;
            count++;
            if(boolDouble == true) {
                cps++;
                count++;
                System.out.println(test.debug + "Clicks doubled.");
            }
            lblclicks.setText("Clicks: " + count);
            System.out.println(test.debug + "Click recognized. (#" + count+ ")");
        }
        
        if(e.getSource() == sec) {
            lblcps.setText("CPS: " + cps + " C/s");
            if(cps > 0) {
                lblcps.setText("CPS: " + cps + " C/s");
                System.out.println(test.debug + "CPS Calculated(" + cps + ")");
                stats.add(cps);

                System.out.println(test.debug + "Stats cached." + stats);
                lbllast.setText("Last results: " + stats);
                for (int i = 0; i < stats.size(); i++) {
                    if(i > 3) {
                        stats.clear();
                        System.out.println(test.debug + "Last results cleared.");
                        stats.add(cps);
                        lbllast.setText("Last results: " + stats);
                    }
                }
                if (cps > hcps) {
                    System.out.println(test.debug + "New Highscore:" + cps);
                    hcps = cps;
                    lblHS.setText("Highscore: " + hcps);
                }
                cps = 0;
            }else {
                lblcps.setText("CPS: " + cps + " C/s");
                System.out.println(test.debug + "Timer stopped.");
                sec.stop();
            }
        }

        if(e.getSource() == btndarkmode) {
            if(boolDarkmode == false) {
                boolDarkmode = true;
                panel.setBackground(Color.DARK_GRAY);
                btndarkmode.setBackground(Color.DARK_GRAY);
                btnclick.setBackground(Color.DARK_GRAY);
                btndarkmode.setForeground(Color.GREEN);
                btnclick.setForeground(Color.WHITE);
                lblclicks.setForeground(Color.WHITE);
                lblcps.setForeground(Color.WHITE);
                lbllast.setForeground(Color.WHITE);
                lblHS.setForeground(Color.WHITE);
                System.out.println(test.debug + "Enabled Darkmode");
            }else {
                boolDarkmode = false;
                panel.setBackground(Color.WHITE);
                btndarkmode.setBackground(Color.WHITE);
                btnclick.setBackground(Color.WHITE);
                btndarkmode.setForeground(Color.RED);
                btnclick.setForeground(Color.BLACK);
                lblclicks.setForeground(Color.BLACK);
                lblcps.setForeground(Color.BLACK);
                lbllast.setForeground(Color.BLACK);
                lblHS.setForeground(Color.BLACK);
                System.out.println(test.debug + "Disabled Darkmode");
            }
        }
    }
}
