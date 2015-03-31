package test.bot.utils;

import com.google.common.collect.UnmodifiableIterator;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by astuti on 31/3/15.
 */
public final class Permissions {

    public static boolean isOperator(String user,MessageEvent event){
        UnmodifiableIterator<User> set =event.getChannel().getOps().descendingIterator();
        while (set.hasNext())
        {
            if(set.next().getNick().equalsIgnoreCase(user))
                return true;

        }
        event.respond("You don't have permissions to do that");
        return false;
    }

    public static boolean isVoiced(String user,MessageEvent event){
        UnmodifiableIterator<User> set =event.getChannel().getVoices().descendingIterator();
        while (set.hasNext())
        {
            if(set.next().getNick().equalsIgnoreCase(user))
                return true;
        }
        event.respond("You don't have permissions to do that");
        return false;
    }
}
