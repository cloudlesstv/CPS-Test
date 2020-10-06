import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    int count;
    int cps;
    Boolean darkmode = new Boolean(false);

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblclicks = new JLabel("Clicks: " + count);
    JLabel lblcps = new JLabel("CPS: " + cps + " C/s");
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

        panel.setBackground(Color.WHITE);
        btndarkmode.setBackground(Color.WHITE);
        btnclick.setBackground(Color.WHITE);
        btndarkmode.setForeground(Color.RED);
        btnclick.setForeground(Color.BLACK);
        lblclicks.setForeground(Color.BLACK);
        lblcps.setForeground(Color.BLACK);

        btnclick.addActionListener(this);
        btndarkmode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnclick) {
            if(!sec.isRunning()) {
                sec.start();
            }
            cps++;
            count++;
            lblclicks.setText("Clicks: " + count);
        }
        
        if(e.getSource() == sec) {
            lblcps.setText("CPS: " + cps + " C/s");
            cps = 0;
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
            }else {
                darkmode = false;
                panel.setBackground(Color.WHITE);
                btndarkmode.setBackground(Color.WHITE);
                btnclick.setBackground(Color.WHITE);
                btndarkmode.setForeground(Color.RED);
                btnclick.setForeground(Color.BLACK);
                lblclicks.setForeground(Color.BLACK);
                lblcps.setForeground(Color.BLACK);
            }
        }
    }
}
