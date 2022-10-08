package org.example;


import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class ChangePresence extends ListenerAdapter {
    private String[] messageClean;
    private String message;


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        message = event.getMessage().getContentRaw();
        messageClean = message.substring(1).split(" ");


        if(message.startsWith(Main.prefix))   {
            System.out.println(message);
            switch(messageClean[1]){
                case "ONLINE":
                    event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE,Activity.watching(setActivity(message)));
                    break;
                case "IDLE":
                    event.getJDA().getPresence().setStatus(OnlineStatus.IDLE);
                    event.getJDA().getPresence().setActivity(Activity.playing(setActivity(message)));
                    break;
                case "DND":
                    event.getJDA().getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
                    event.getJDA().getPresence().setActivity(Activity.playing(setActivity(message)));
                    break;
                case "INVI":
                    event.getJDA().getPresence().setStatus(OnlineStatus.INVISIBLE);
                    break;
            }
        }
    }
    public String setActivity(String message){
        String activity[] = message.split("-");
        return activity[1];
    }

}
