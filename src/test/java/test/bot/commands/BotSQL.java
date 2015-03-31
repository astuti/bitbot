package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import test.bot.utils.SQLlistener;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Command !addme adds the user's nick in a database.
 */
public class BotSQL extends SQLlistener{


    public BotSQL(){
        setupDB();
    }

    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        if(event.getMessage().equalsIgnoreCase("!addme"))
        {
            addUser(event.getUser().getNick());
        }
    }

    public void addUser(String nick) {
        openConnection();
        String query = "INSERT INTO `BOTUSER` (NAME) VALUES(?)";
        PreparedStatement statement= null;
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, nick);
            statement.executeUpdate();
            statement.close();
            closeConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setupDB() {
        Statement statement= null;
        try {
            openConnection();
            statement= conn.createStatement();
            String query= "CREATE TABLE IF NOT EXISTS 'BOTUSER' (NAME CHAR(50) );";
            statement.executeUpdate(query);
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
