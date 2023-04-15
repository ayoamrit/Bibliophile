package com.bibliophile.selection;

import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GenreSelectionMenu {

    /**
     * Creates a StringSelectMenu for selecting a book genre for suggestion
     * @return the StringSelectMenu for book genre suggestion
     */
    public StringSelectMenu genreSuggestionMenu(){
        //The custom ID for the genre selection menu button
        String customId = "suggest:genre";

        //The placeholder text for the genre selection menu dropdown
        String placeholder = "Choose a genre";

        //Create a new StringSelectMenu Builder with a custom ID and a placeholder
        StringSelectMenu.Builder selectMenuBuilder = StringSelectMenu.create(customId)
                        .setPlaceholder(placeholder);

        //Call method to get the list of options for the StringSelectMenu
        //and add the options to the StringSelectMenu.Builder
        selectMenuBuilder.addOptions(getOptionList());

        //Build and return the StringSelectMenu.Builder
        return selectMenuBuilder.build();
    }

    /**
     * Creates a list of SelectOptions for a book genre selection menu
     * @return the list of SelectOptions
     */
    @NotNull
    private ArrayList<SelectOption> getOptionList(){
        //Create a new ArrayList to hold the SelectOptions
        ArrayList<SelectOption> optionList = new ArrayList<>();

        //Add SelectOptions for each book genre
        optionList.add(SelectOption.of("Fantasy", "fantasy"));
        optionList.add(SelectOption.of("Crime","crime"));
        optionList.add(SelectOption.of("Fiction","fiction"));
        optionList.add(SelectOption.of("Non-Fiction","non-fiction"));
        optionList.add(SelectOption.of("Mystery", "mystery"));
        optionList.add(SelectOption.of("Horror","horror"));
        optionList.add(SelectOption.of("Romance","romance"));
        optionList.add(SelectOption.of("Biography","biography"));
        optionList.add(SelectOption.of("Auto-Biography", "auto-biography"));
        optionList.add(SelectOption.of("Poetry","poetry"));
        optionList.add(SelectOption.of("Literature","literature"));
        optionList.add(SelectOption.of("Science","science"));
        optionList.add(SelectOption.of("Sports", "sports"));
        optionList.add(SelectOption.of("Business","business"));
        optionList.add(SelectOption.of("Religious","religious"));
        optionList.add(SelectOption.of("Adventure","adventure"));

        //Return the list of SelectOptions
        return optionList;
    }


}
