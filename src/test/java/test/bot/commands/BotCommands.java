package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by astuti on 29/3/15.
 */
public class BotCommands extends ListenerAdapter<PircBotX>{

    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
                if(event.getMessage().equalsIgnoreCase("!hello")){
                    event.getChannel().send().message("Hi  " + event.getUser().getNick()+". Good to hear from you!");
                }

                if(event.getMessage().split(" ")[0].equalsIgnoreCase("!join"))
                {
                     if(event.getMessage().split(" ").length>1)
                         event.getBot().sendIRC().joinChannel(event.getMessage().split(" ")[1]);
                }

    }
}
