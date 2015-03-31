package test.bot.commands;

import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by astuti on 31/3/15.
 */
public class AdvancedCommandHello extends AdvancedCommandBase{
    @Override
    public void executeCommand(MessageEvent event) {
        super.executeCommand(event);
        if(args[0].equalsIgnoreCase("!hello")){
            event.respond("Hey ...!");
        }
    }
}
