import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEventHandler implements ActionListener, MouseListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RPC.update();
        if(e.getSource() == GUI.btnclick) {
            DatabaseHandler.setTotal();
            if(!Main.sec.isRunning()) {
                Main.sec.start();
                Debug.printStacktrace("Timer started");
            }
            Main.cps++;
            Main.count++;
            if(Main.boolDouble == true) {
                Main.cps++;
                Main.count++;
                Debug.printStacktrace("Clicks doubled.");
            }
            GUI.lblclicks.setText("Clicks: " + Main.count);
            Debug.printStacktrace("Click recognized (#" + Main.count + ")");

        }


        if(e.getSource() == Main.sec) {
            GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
            if(Main.cps > 0) {
                GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
                Debug.printStacktrace("CPS Calculated(" + Main.cps + ")");
                Main.stats.add(Main.cps);

                Debug.printStacktrace("Stats cached." + Main.stats);
                GUI.lbllast.setText("Last results: " + Main.stats);
                for (int i = 0; i < Main.stats.size(); i++) {
                    if(i > 3) {
                        Main.stats.clear();
                        Debug.printStacktrace("Last results cleared.");
                        Main.stats.add(Main.cps);
                        GUI.lbllast.setText("Last results: " + Main.stats);

                    }
                }
                if (Main.cps > Main.hcps) {
                    Debug.printStacktrace("New Highscore:" + Main.cps);
                    Main.hcps = Main.cps;
                    GUI.lblHS.setText("Highscore: " + Main.hcps);
                }
                Main.cps = 0;
            }else {
                GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
                Debug.printStacktrace("Timer stopped.");
                Main.sec.stop();
            }
        }

        if(e.getSource() == GUI.btnSettings) {
            new Settings();
        }else {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        DatabaseHandler.setTotal();
        if(!Main.sec.isRunning()) {
            Main.sec.start();
            Debug.printStacktrace("Timer started");
        }
        Main.cps++;
        Main.count++;
        if(Main.boolDouble) {
            Main.cps++;
            Main.count++;
            Debug.printStacktrace("Clicks doubled.");
        }
        GUI.lblclicks.setText("Clicks: " + Main.count);
        Debug.printStacktrace("Click recognized (#" + Main.count + ")");

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
