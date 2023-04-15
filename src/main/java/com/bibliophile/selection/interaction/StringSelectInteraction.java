package com.bibliophile.selection.interaction;

import com.bibliophile.event.EventReply;
import com.bibliophile.openai.query.Query;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.bibliophile.openai.OpenAiApiHandler;
import org.jetbrains.annotations.NotNull;

public class StringSelectInteraction extends ListenerAdapter implements EventReply {

    //This method is called when a string select interaction event occurs
    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event){
        OpenAiApiHandler apiHandler = new OpenAiApiHandler();

        //If the "suggest:genre" component is selected
        if ("suggest:genre".equals(event.getComponentId())) {

            //Getting selected genre using event
            String selectedGenre = event.getValues().get(0);

            //Create a query for the selected genre
            String query = new Query().BookSuggestionQuery(selectedGenre);

            //Get the user and the prompt
            String user = event.getUser().getId();
            String prompt = apiHandler.getPrompt(query);

            //Reply to the interaction with the formatted completion and user mention
            event.reply(eventReply(user, prompt)).queue();

        }
        //If the "suggest:language" component is selected
        else if("suggest:language".equals(event.getComponentId())){
            //Getting selected language using event
            String selectedLanguage = event.getValues().get(0);

            //Create a query for the selected language
            String query = new Query().BookSuggestionLanguageQuery(selectedLanguage);

            //Get the user and the prompt
            String user = event.getUser().getId();
            String prompt = apiHandler.getPrompt(query);

            //Reply to the interaction with the formatted completion and user mention
            event.reply(eventReply(user,prompt)).queue();
        }
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
}
