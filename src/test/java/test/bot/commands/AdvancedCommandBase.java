package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by astuti on 31/3/15.
 */
public class AdvancedCommandBase extends ListenerAdapter<PircBotX>{

    String message;
    String[] args;
    String sender;
    String channel;

    public void executeCommand(MessageEvent event){
        message= event.getMessage();
        args = message.split(" ");
        sender= event.getUser().getNick();
        channel= event.getChannel().getName();
    }

}
