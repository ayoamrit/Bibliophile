package com.bibliophile.slashcommand;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class SlashCommand {

    //Define a Slash Command for getting a random book suggestion
    public CommandData randomBookSuggestionSlashCommand(){
        return Commands.slash("book-suggestion","Get a random book suggestion");
    }

    //Define a Slash Command for getting a book suggestion based on the genre preference
    public CommandData bookSuggestionByGenreSlashCommand(){
        return Commands.slash("book-suggestion-genre","Get a book suggestion based on your genre preference");
    }

    //Define a Slash Command for getting a book suggestion based on the language preference
    public CommandData bookSuggestionByLanguageSlashCommand(){
        return Commands.slash("book-suggestion-language","Get a book suggestion based on your genre preference");
    }

    //Define a Slash Command for getting the information about a person
    public CommandData whoIsSlashCommand(){
        return Commands.slash("whois","Get to know about a person by his/her name")
                .addOption(OptionType.STRING, "name", "Enter name of the person",true,false);
    }

    //Define a Slash Command for getting the definition of a word
    public CommandData dictionarySlashCommand(){
        return Commands.slash("dictionary","Get meaning of a word")
                .addOption(OptionType.STRING, "word","Enter the word",true, false);
    }

    public CommandData quoteSlashCommand(){
        return Commands.slash("quote","Get quote");
    }
}
