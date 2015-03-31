package test.bot.utils;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is abstract class for managing db interactions(mysql) via jdbc.
 * */

public abstract class SQLlistener extends ListenerAdapter<PircBotX> {
    public java.sql.Connection conn = null;

    public SQLlistener() {
        setupDB();
    }

    public abstract void setupDB();

    public void openConnection() {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/BITBOT?" + "user=root&password=root");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("sql exception in open conn");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("class not found in open conn");
            }
        }


    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    }
