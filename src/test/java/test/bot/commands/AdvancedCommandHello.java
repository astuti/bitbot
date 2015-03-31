package test.bot.commands;

import org.pircbotx.hooks.events.MessageEvent;

/**
 *For '?hello' command
 */
public class AdvancedCommandHello extends AdvancedCommandBase{
    @Override
    public void executeCommand(MessageEvent event) {
        super.executeCommand(event);
        if(args[0].equalsIgnoreCase("?hello")){
            event.respond("Hey ...!");
        }
    }
}
