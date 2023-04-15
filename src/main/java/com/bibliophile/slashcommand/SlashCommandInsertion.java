package com.bibliophile.slashcommand;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import java.util.ArrayList;

public class SlashCommandInsertion {

    /**
     * Constructor for SlashCommandInsertion class
     * This method is used to insert slash command into an
     * ArrayList of CommandData objects.
     * @param slashCommandList an ArrayList of CommandData objects to which
     *                         the slash commands will be added
     */
    public SlashCommandInsertion(ArrayList<CommandData> slashCommandList){
        //Create a new SlashCommand object
        SlashCommand slashCommand = new SlashCommand();

        //Add the different slash commands to the slashCommandList ArrayList
        slashCommandList.add(slashCommand.randomBookSuggestionSlashCommand());
        slashCommandList.add(slashCommand.bookSuggestionByGenreSlashCommand());
        slashCommandList.add(slashCommand.bookSuggestionByLanguageSlashCommand());
        slashCommandList.add(slashCommand.whoIsSlashCommand());
        slashCommandList.add(slashCommand.dictionarySlashCommand());
        slashCommandList.add(slashCommand.quoteSlashCommand());
    }
}
