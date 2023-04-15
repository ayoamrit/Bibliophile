package com.bibliophile.slashcommand;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.ArrayList;

public class GuildReady extends ListenerAdapter {

    //This method is called when the bot has connected to a Guild (Discord Server)
    //and  is ready to start receiving events.
    @Override
    public void onGuildReady(GuildReadyEvent event){

        //Create a new ArrayList to hold the Slash Commands
        ArrayList<CommandData> slashCommandList = new ArrayList<>();

        //Call the SlashCommandInsertion class to add the desired Slash Commands to the ArrayList
        new SlashCommandInsertion(slashCommandList);

        //Update the Slash Commands on the Discord server with the commands in the slashCommandList ArrayList
        event.getGuild().updateCommands().addCommands(slashCommandList).queue();
    }
}
