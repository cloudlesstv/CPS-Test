import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    int count;
    int cps;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblclicks = new JLabel("Clicks: " + count);
    JLabel lblcps = new JLabel("CPS: " + cps + " C/s");
    JButton btnclick = new JButton("Klick mich");

    Timer sec = new Timer(1000, this);

    public GUI() {
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.add(lblclicks);
        panel.add(lblcps);
        panel.add(btnclick);

        btnclick.addActionListener(this);
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
    }
}
