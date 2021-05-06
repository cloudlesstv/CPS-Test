import java.sql.*;

public class DatabaseHandler {

    static String cloudkey_logged =  "";

    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void setConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cps", "root", "");
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists cloudkey (cloudkey VARCHAR(255) unique, total INTEGER(255))");
            Debug.printStacktrace("Connected to Database");
        } catch (Exception throwable) {

        }
    }

    public static void register(String cloudkey, int Total) {
        cloudkey_logged = cloudkey;
        try {
            statement.executeUpdate("INSERT INTO cloudkey (cloudkey, total) values ('" + cloudkey + "', '" + Total + "')");
            Debug.printStacktrace("Register complete.");
            GUI.lblclicks.setText("Clicks: " + getTotal(cloudkey_logged));
            Main.count = getTotal(cloudkey_logged);
            Debug.printStacktrace("Total merged.");
        } catch (SQLException throwables) {
            Debug.printStacktrace("Login complete.");
            GUI.lblclicks.setText("Clicks: " + getTotal(cloudkey_logged));
            Main.count = getTotal(cloudkey_logged);
            Debug.printStacktrace("Total merged.");
        }
    }

    public static int getTotal(String cloudkey) {
        try {
            resultSet = statement.executeQuery("select * from cloudkey where cloudkey = '" + cloudkey + "'");
            while (resultSet.next()) {
                return resultSet.getInt("total");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static void setTotal() {
        try {
            statement.executeUpdate("UPDATE cloudkey SET total = " + (getTotal(cloudkey_logged) + 1) + " WHERE cloudkey = '" + cloudkey_logged + "'");
            Debug.printStacktrace("Updated Total.");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
