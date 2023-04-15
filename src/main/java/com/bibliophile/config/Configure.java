package com.bibliophile.config;

import com.bibliophile.selection.interaction.StringSelectInteraction;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import com.bibliophile.slashcommand.SlashCommandInteraction;
import com.bibliophile.slashcommand.GuildReady;

public class Configure {

    public Configure(){

        //calling method to configure the Discord bot
        setBotConfiguration();
    }

    private String getToken(){

        //Load environment variables from a .env file in the "ref" directory
        Dotenv configuration = Dotenv.configure().directory("ref/.env").load();

        //Return the value of the "TOKEN" environment variable
        //(which should contain the bot token)
        return configuration.get("TOKEN");
    }


    private void setBotConfiguration(){

        //create a JDA instance using the default configuration
        //and a bot token string
        JDABuilder builder = JDABuilder.createDefault(getToken());

        //set the bot's online status to "ONLINE"
        builder.setStatus(OnlineStatus.ONLINE);

        //set the bot's activity to "watching Shakespeare's plays"
        builder.setActivity(Activity.watching("Hamlet"));

        //enable the MESSAGE_CONTENT intent to receive message events from Discord
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);

        //create a new instance of a builder and add event listeners for
        //slash commands and guild readiness
        builder.addEventListeners(new SlashCommandInteraction(), new GuildReady(), new StringSelectInteraction());

        //build the JDA instance with the configured options
        builder.build();
    }
}
