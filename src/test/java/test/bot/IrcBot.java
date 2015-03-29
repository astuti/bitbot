package test.bot;

import org.pircbotx.PircBotX;

import org.pircbotx.Configuration;
import org.pircbotx.exception.IrcException;
import test.bot.commands.BotCommands;
import test.bot.events.EventHandler;

import java.io.IOException;

/**
 * Created by astuti on 29/3/15.
 */
public class IrcBot {

    public static void main (String[] args){
        new IrcBot();
    }

    Configuration<PircBotX> config = new Configuration.Builder<PircBotX>()
            .setName("IrcBot")
            .setLogin("mIrcBot")
            .setAutoNickChange(true)
            .setServerHostname("irc.freenode.net")
            .setServerPort(8001)
            .addAutoJoinChannel("#PircBotX")
            .addListener(new BotCommands())
            .addListener(new EventHandler())
            .buildConfiguration();


    public IrcBot(){
            PircBotX bot = new PircBotX(config);
        try {
            bot.startBot();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }
    }
}