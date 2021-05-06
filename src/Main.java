
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static int count;
    static int cps;
    static int hcps;

    static public ArrayList<Integer> stats = new ArrayList<Integer>();

    static Boolean boolDouble = Boolean.FALSE;

    static String debug = "[Debug]";

    static Timer sec = new Timer(1000, new ActionEventHandler());

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Welcome to CPS-Test by CloudLessTv");
        Debug.printStacktrace("Debug started.");
        System.out.println("");
        RPC.start();
        RPC.update();
        DatabaseHandler.setConnection();
        new GUI();
        new Colors();
    }
}
