package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Class stores the attributes of an event.To be extended in refactored command classes.
 */
public class RefactoredCommandBase extends ListenerAdapter<PircBotX>{

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
