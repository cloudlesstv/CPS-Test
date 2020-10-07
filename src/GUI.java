import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class GUI implements ActionListener {

    int count;
    int cps;

    public ArrayList<Integer> stats = new ArrayList<>();

    Boolean darkmode = new Boolean(false);

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblclicks = new JLabel("Clicks: " + count);
    JLabel lblcps = new JLabel("CPS: " + cps + " C/s");
    JButton btnclick = new JButton("Click");
    JButton btndarkmode = new JButton("Darkmode");
    JLabel lbllast = new JLabel("Last results: not available");

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

        panel.setBackground(Color.WHITE);
        btndarkmode.setBackground(Color.WHITE);
        btnclick.setBackground(Color.WHITE);
        btndarkmode.setForeground(Color.RED);
        btnclick.setForeground(Color.BLACK);
        lblclicks.setForeground(Color.BLACK);
        lblcps.setForeground(Color.BLACK);
        lbllast.setForeground(Color.BLACK);

        btnclick.addActionListener(this);
        btndarkmode.addActionListener(this);
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
                cps = 0;
            }else {
                lblcps.setText("CPS: " + cps + " C/s");
                System.out.println(test.debug + "Timer stopped.");
                sec.stop();
            }
        }

        if(e.getSource() == btndarkmode) {
            if(darkmode == false) {
                darkmode = true;
                panel.setBackground(Color.BLACK);
                btndarkmode.setBackground(Color.BLACK);
                btnclick.setBackground(Color.BLACK);
                btndarkmode.setForeground(Color.GREEN);
                btnclick.setForeground(Color.WHITE);
                lblclicks.setForeground(Color.WHITE);
                lblcps.setForeground(Color.WHITE);
                lbllast.setForeground(Color.WHITE);
                System.out.println(test.debug + "Enabled Darkmode");
            }else {
                darkmode = false;
                panel.setBackground(Color.WHITE);
                btndarkmode.setBackground(Color.WHITE);
                btnclick.setBackground(Color.WHITE);
                btndarkmode.setForeground(Color.RED);
                btnclick.setForeground(Color.BLACK);
                lblclicks.setForeground(Color.BLACK);
                lblcps.setForeground(Color.BLACK);
                lbllast.setForeground(Color.BLACK);
                System.out.println(test.debug + "Disabled Darkmode");
            }
        }
    }
}
