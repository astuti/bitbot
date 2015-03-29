package test.bot.events;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.InviteEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

/**
 * Created by astuti on 29/3/15.
 */
public class EventHandler extends ListenerAdapter<PircBotX> {
    @Override
    public void onJoin(JoinEvent<PircBotX> event) throws Exception {
        if(!event.getUser().getNick().equalsIgnoreCase(event.getBot().getNick())) {
            event.getChannel().send().message("Welcome  " + event.getUser().getNick());
        }
    }

    @Override
    public void onInvite(InviteEvent<PircBotX> event) throws Exception {
        System.out.println(event.getChannel());
        event.getBot().sendIRC().joinChannel(event.getChannel());
    }

    @Override
    public void onPrivateMessage(PrivateMessageEvent<PircBotX> event) throws Exception {
        if(event.getMessage().equalsIgnoreCase("hi"))
                event.respond("Hello !!!");
    }
}
