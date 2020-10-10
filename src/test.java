import javax.swing.*;
import java.util.ArrayList;

public class test {

    static int count;
    static int cps;
    static int hcps;

    static public ArrayList<Integer> stats = new ArrayList<Integer>();

    static Boolean boolDouble = Boolean.FALSE;

    static String debug = new String("[Debug]");

    static Timer sec = new Timer(1000, new ActionEventHandler());

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Welcome to CPS-Test by CloudLessTv");
        System.out.println("Debug started");
        System.out.println("");
        new GUI();
    }
}
