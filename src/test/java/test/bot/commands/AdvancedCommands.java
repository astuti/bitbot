package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.HashMap;

/**
 * Created by astuti on 31/3/15.
 */
public class AdvancedCommands extends ListenerAdapter<PircBotX>{

    HashMap<String, AdvancedCommandBase> cmd = new HashMap<String, AdvancedCommandBase>();

    public AdvancedCommands(){
            cmd.clear();
            cmd.put("hello",new AdvancedCommandHello());
    }

    @Override
    public void onMessage(MessageEvent<PircBotX> event) throws Exception {
        super.onMessage(event);
      if(  event.getMessage().split(" ")[0].substring(0,1).equalsIgnoreCase("?"))
                if(cmd.containsKey(event.getMessage().split(" ")[0].substring(1))){
                    cmd.get(event.getMessage().split(" ")[0].substring(1)).executeCommand(event);
                }
    }
}
