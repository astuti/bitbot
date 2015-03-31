package test.bot;

import org.pircbotx.PircBotX;

import org.pircbotx.Configuration;
import org.pircbotx.exception.IrcException;
import test.bot.commands.AdvancedCommands;
import test.bot.commands.BotCommands;
import test.bot.commands.BotSQL;
import test.bot.events.EventHandler;

import java.io.IOException;

/**
 * This class configures bot and starts it.
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
            .addListener(new BotSQL())
            .addListener(new AdvancedCommands())
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
