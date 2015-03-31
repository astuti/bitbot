package test.bot.utils;

import com.google.common.collect.UnmodifiableIterator;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Final class with static methods used to check operator and voice persmissions of a user.
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
