package test.bot.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.HashMap;


/**
* Refractoring commands: This class maintains a list of all commands.
**/

public class RefactoredCommands extends ListenerAdapter<PircBotX>{

    HashMap<String, RefactoredCommandBase> cmd = new HashMap<String, RefactoredCommandBase>();

    public RefactoredCommands(){
            cmd.clear();
            cmd.put("hello",new RefactoredCommandHello());
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
