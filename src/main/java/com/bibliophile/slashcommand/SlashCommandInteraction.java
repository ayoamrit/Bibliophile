package com.bibliophile.slashcommand;

import com.bibliophile.event.EventReply;
import com.bibliophile.selection.GenreSelectionMenu;
import com.bibliophile.openai.query.Query;
import com.bibliophile.openai.OpenAiApiHandler;
import com.bibliophile.selection.LanguageSelectionMenu;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SlashCommandInteraction extends ListenerAdapter implements EventReply {

    //Instantiate a new OpenAiApiHandler object
    private final static OpenAiApiHandler apiHandler = new OpenAiApiHandler();

    /**
     * This method is called when a slash command interaction event is received by the bot.
     * @param event the slash command interaction event object
     */
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

        //Use a switch statement to handle the different Slash Commands that the bot can receive
        switch(event.getName()){

            //If the Slash Command is "book-suggestion"
            case "book-suggestion":{
                //Create a new Query object and get a book suggestion
                String query = new Query().BookSuggestionQuery();

                //Get the user ID and the completion prompt
                String user = getUser(event);
                String prompt = getCompletionResult(query);

                //Reply to the discord server
                event.reply(eventReply(user, prompt)).queue();

                break;
            }
            //If the Slash Command is "book-suggestion-genre"
            case "book-suggestion-genre":{
                //Create a new GenreSelectionMenu object
                GenreSelectionMenu genreSuggestionMenu = new GenreSelectionMenu();

                //Get the action row for the genre suggestion menu and reply to the Discord server
                event.replyComponents(ActionRow.of(genreSuggestionMenu.genreSuggestionMenu())).queue();
                break;
            }
            //If the Slash Command is "book-suggestion-language"
            case "book-suggestion-language":{
                //Create a new LanguageSelectionMenu object
                LanguageSelectionMenu languageSelectionMenu = new LanguageSelectionMenu();

                //Get the action row for the language suggestion menu and reply to the Discord sever
                event.replyComponents(ActionRow.of(languageSelectionMenu.languageSelectionMenu())).queue();
                break;
            }

            //when the command is "whois"
            case "whois":{
                //Get the ID of the user who sent the command
                String user = getUser(event);

                //Get the name of the person being searched for
                String getOption = Objects.requireNonNull(event.getOption("name")).getAsString();

                //Generate a query to search for the information about the person
                String query = new Query().whoIsQuery(getOption);

                //Execute the query and get the results
                String prompt = getCompletionResult(query);

                //Send a message to the Discord channel with the search results
                event.reply(eventReply(user, prompt)).queue();
            }

            case "dictionary":{
                //Get the user's id
                String user = getUser(event);

                //Get the word the user want to look up in the dictionary
                String getOption = Objects.requireNonNull(event.getOption("word")).getAsString();

                //Generate a query to get the meaning of the word
                String query = new Query().dictionaryQuery(getOption);

                //Execute the query and get the results
                String prompt = getCompletionResult(query);

                //Send a message to the Discord channel with the search results
                event.reply(eventReply(user, prompt)).queue();
            }

            case "quote":{
                //Get the user's id
                String user = getUser(event);

                //Generate a query to get a quote
                String query = new Query().quoteQuery();

                //Execute the query and get the results
                String prompt = getCompletionResult(query);

                //Send a message to the Discord channel with the search results
                event.reply(eventReply(user, prompt)).queue();
            }
        }
    }

    /**
     * This method takes a query as input and calls an OpenAIApi handler to get a completion
     * @param query the query to be completed
     * @return the completion result as a String
     */
    private String getCompletionResult(String query){
        //Calls an OpenAiApi handler to get the completion result for the query
        return apiHandler.getPrompt(query);
    }

    /**
     * This method formats the completion prompt and mentions
     * the user who issued the command
     * @param user the user who issued the command
     * @param prompt the completion to be formatted
     * @return a formatted string containing the completion prompt and the user mention
     */
    public String eventReply(@NotNull String user, @NotNull String prompt){
        return "<@"+user+"> ```"+prompt+"```";
    }

    /**
     * Returns the ID of the user who triggered the command
     * @param event the SlashCommandInteractionEvent object representing the user's command
     * @return a string representing the user's ID
     */
    private String getUser(SlashCommandInteractionEvent event){
        //Get the user object from the event and return its ID
        return event.getUser().getId();
    }

}
