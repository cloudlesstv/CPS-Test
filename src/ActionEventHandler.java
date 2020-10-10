import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == GUI.btnclick) {
            if(!test.sec.isRunning()) {
                test.sec.start();
                System.out.println(test.debug + "Timer Started");
            }
            test.cps++;
            test.count++;
            if(test.boolDouble == true) {
                test.cps++;
                test.count++;
                System.out.println(test.debug + "Clicks doubled.");
            }
            GUI.lblclicks.setText("Clicks: " + test.count);
            System.out.println(test.debug + "Click recognized. (#" + test.count+ ")");

        }

        if(e.getSource() == test.sec) {
            GUI.lblcps.setText("CPS: " + test.cps + " C/s");
            if(test.cps > 0) {
                GUI.lblcps.setText("CPS: " + test.cps + " C/s");
                System.out.println(test.debug + "CPS Calculated(" + test.cps + ")");
                test.stats.add(test.cps);

                System.out.println(test.debug + "Stats cached." + test.stats);
                GUI.lbllast.setText("Last results: " + test.stats);
                for (int i = 0; i < test.stats.size(); i++) {
                    if(i > 3) {
                        test.stats.clear();
                        System.out.println(test.debug + "Last results cleared.");
                        test.stats.add(test.cps);
                        GUI.lbllast.setText("Last results: " + test.stats);
                    }
                }
                if (test.cps > test.hcps) {
                    System.out.println(test.debug + "New Highscore:" + test.cps);
                    test.hcps = test.cps;
                    GUI.lblHS.setText("Highscore: " + test.hcps);
                }
                test.cps = 0;
            }else {
                GUI.lblcps.setText("CPS: " + test.cps + " C/s");
                System.out.println(test.debug + "Timer stopped.");
                test.sec.stop();
            }
        }

        if(e.getSource() == GUI.btndarkmode) {
            if(GUI.boolDarkmode == false) {
                GUI.boolDarkmode = true;
                GUI.panel.setBackground(colorPalette.Gunmetal);
                GUI.btndarkmode.setBackground(colorPalette.Bdazzled_Blue);
                GUI.btnclick.setBackground(colorPalette.Bdazzled_Blue);
                GUI.btndarkmode.setForeground(colorPalette.Android_Green);
                GUI.btnclick.setForeground(colorPalette.Cultured);
                GUI.lblclicks.setForeground(colorPalette.Pale_Cerulean);
                GUI.lblcps.setForeground(colorPalette.Pale_Cerulean);
                GUI.lbllast.setForeground(colorPalette.Pale_Cerulean);
                GUI.lblHS.setForeground(colorPalette.Pale_Cerulean);
                System.out.println(test.debug + "Enabled Darkmode");
            }else {
                GUI.boolDarkmode = false;
                GUI.panel.setBackground(colorPalette.Gainsboro);
                GUI.btndarkmode.setBackground(colorPalette.Light_Cyan);
                GUI.btnclick.setBackground(colorPalette.Light_Cyan);
                GUI.btndarkmode.setForeground(colorPalette.Imperial_Red);
                GUI.btnclick.setForeground(colorPalette.Rich_Black_FOGRA_39);
                GUI.lblclicks.setForeground(colorPalette.Charcoal);
                GUI.lblcps.setForeground(colorPalette.Charcoal);
                GUI.lbllast.setForeground(colorPalette.Charcoal);
                GUI.lblHS.setForeground(colorPalette.Charcoal);
                System.out.println(test.debug + "Disabled Darkmode");
            }
        }
    }
}
