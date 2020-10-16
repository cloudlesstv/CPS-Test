import java.awt.event.*;

public class ActionEventHandler implements ActionListener, KeyListener, MouseListener {

    Boolean boolSpace = new Boolean(Boolean.FALSE);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == GUI.btnclick) {
            if(!Main.sec.isRunning()) {
                Main.sec.start();
                System.out.println(Main.debug + "Timer Started");
            }
            Main.cps++;
            Main.count++;
            if(Main.boolDouble == true) {
                Main.cps++;
                Main.count++;
                System.out.println(Main.debug + "Clicks doubled.");
            }
            GUI.lblclicks.setText("Clicks: " + Main.count);
            System.out.println(Main.debug + "Click recognized. (#" + Main.count+ ")");
        }

        if(e.getSource() == Main.sec) {
            GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
            if(Main.cps > 0) {
                GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
                System.out.println(Main.debug + "CPS Calculated(" + Main.cps + ")");
                Main.stats.add(Main.cps);

                System.out.println(Main.debug + "Stats cached." + Main.stats);
                GUI.lbllast.setText("Last results: " + Main.stats);
                for (int i = 0; i < Main.stats.size(); i++) {
                    if(i > 3) {
                        Main.stats.clear();
                        System.out.println(Main.debug + "Last results cleared.");
                        Main.stats.add(Main.cps);
                        GUI.lbllast.setText("Last results: " + Main.stats);
                    }
                }
                if (Main.cps > Main.hcps) {
                    System.out.println(Main.debug + "New Highscore:" + Main.cps);
                    Main.hcps = Main.cps;
                    GUI.lblHS.setText("Highscore: " + Main.hcps);
                }
                Main.cps = 0;
            }else {
                GUI.lblcps.setText("CPS: " + Main.cps + " C/s");
                System.out.println(Main.debug + "Timer stopped.");
                Main.sec.stop();
            }
        }

        if(e.getSource() == GUI.btndarkmode) {
            if(GUI.boolDarkmode == false) {
                GUI.boolDarkmode = true;
                GUI.panel.setBackground(Colors.Gunmetal);
                GUI.btndarkmode.setBackground(Colors.Bdazzled_Blue);
                GUI.btnclick.setBackground(Colors.Bdazzled_Blue);
                GUI.btndarkmode.setForeground(Colors.Android_Green);
                GUI.btnclick.setForeground(Colors.Cultured);
                GUI.lblclicks.setForeground(Colors.Pale_Cerulean);
                GUI.lblcps.setForeground(Colors.Pale_Cerulean);
                GUI.lbllast.setForeground(Colors.Pale_Cerulean);
                GUI.lblHS.setForeground(Colors.Pale_Cerulean);
                System.out.println(Main.debug + "Enabled Darkmode");
            }else {
                GUI.boolDarkmode = false;
                GUI.panel.setBackground(Colors.Gainsboro);
                GUI.btndarkmode.setBackground(Colors.Light_Cyan);
                GUI.btnclick.setBackground(Colors.Light_Cyan);
                GUI.btndarkmode.setForeground(Colors.Imperial_Red);
                GUI.btnclick.setForeground(Colors.Rich_Black_FOGRA_39);
                GUI.lblclicks.setForeground(Colors.Charcoal);
                GUI.lblcps.setForeground(Colors.Charcoal);
                GUI.lbllast.setForeground(Colors.Charcoal);
                GUI.lblHS.setForeground(Colors.Charcoal);
                System.out.println(Main.debug + "Disabled Darkmode");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    @Override
    public void mouseClicked(MouseEvent e) {

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
