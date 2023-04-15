package com.bibliophile.selection;

import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LanguageSelectionMenu {

    /**
     * This method creates and return a language selection menu as a StringSelectMenu object
     * @return a StringSelectMenu object representing a language selection menu
     */
    public StringSelectMenu languageSelectionMenu(){

        //Set the custom ID and placeholder for the language selection menu
        String customId = "suggest:language";
        String placeholder = "Choose a language";

        //Create a new StringSelectMenu builder and set the custom ID and placeholder
        StringSelectMenu.Builder selectMenuBuilder = StringSelectMenu.create(customId)
                .setPlaceholder(placeholder);

        //Add options to the StringSelectMenu builder using the getOption() method
        selectMenuBuilder.addOptions(getOption());

        //Build and return the StringSelectMenu object
        return selectMenuBuilder.build();
    }

    /**
     * This method returns an ArrayList of SelectOption object for the language selection menu
     * @return an ArrayList of SelectOption objects for the language selection menu
     */
    @NotNull
    private ArrayList<SelectOption> getOption(){
        ArrayList<SelectOption> optionList = new ArrayList<>();

        //Get the list of languages as an array
        String[] languageArray = getArray();

        //Add each language as a SelectOption of the ArrayList
        for(int x = 0; x<languageArray.length; x++){
            optionList.add(SelectOption.of(languageArray[x], languageArray[x].toLowerCase()));
        }

        //Return the ArrayList of SelectOption objects
        return optionList;
    }

    /**
     * This method returns an array of languages as Strings.
     * @return an array of languages as Strings
     */
    private String[] getArray(){
        String[] language;
        language = new String[]{"Mandarin","Spanish","English","Hindi","Arabic","Bengali","Portuguese",
                                "Russian","Japanese","Punjabi"};
        return language;
    }
}
