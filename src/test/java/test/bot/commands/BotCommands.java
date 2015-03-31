package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import static test.bot.utils.Permissions.isOperator;
import static test.bot.utils.Permissions.isVoiced;

/**
 * Created by astuti on 29/3/15.
 */
public class BotCommands extends ListenerAdapter<PircBotX>{

    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {



                if(event.getMessage().equalsIgnoreCase("!hello")){
                    if(isVoiced(event.getUser().getNick(), event))
                    event.getChannel().send().message("Hi  " + event.getUser().getNick()+". Good to hear from you!");

                }


                if(event.getMessage().split(" ")[0].equalsIgnoreCase("!welcome")){
                   if( isOperator(event.getUser().getNick(), event) ) {
                       if (event.getMessage().split(" ").length > 1)
                           event.getChannel().send().message("Welcome " + event.getMessage().split(" ")[1] + " !!!");
                       else
                           event.getChannel().send().message("please provide an argument.");
                   }
                }

                if(event.getMessage().split(" ")[0].equalsIgnoreCase("!join")) {
                     if(event.getMessage().split(" ").length>1)
                         event.getBot().sendIRC().joinChannel(event.getMessage().split(" ")[1]);
                    else
                         event.getChannel().send().message("provide arg to join command");
                }

    }
}
