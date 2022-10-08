package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public  JDA jda;
    public final static String prefix = "*";
    private final String TOKEN = "MTAyNzk5NzU0NTI5MDUzMDg4OA.GJ9Qqf.tKgAEBgg-tAC0x1PQLRWXq8gpU1A2ifZLyTV8Y";
    Main()  throws LoginException {
         jda = JDABuilder.createDefault(TOKEN).build();
        System.out.println("BOT IS RUNNING");
        setPresence();
        jda.addEventListener(new ChangePresence());
    }
    private void setPresence(){
        jda.getPresence().setPresence(OnlineStatus.ONLINE,Activity.playing("CODING THE BOT"),true);
    }



    public static void main(String[] args) throws LoginException {
        new Main();
        new ChangePresence();
    }
}