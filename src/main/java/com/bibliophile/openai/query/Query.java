package com.bibliophile.openai.query;

public class Query {

    //Method to get a general book suggestion with a short description
    public String BookSuggestionQuery(){
        return "Suggest me a book with its short description";
    }

    //Method to get a book suggestion of a specific genre with a short description
    public String BookSuggestionQuery(String genre){
        return "Suggest me a book of "+genre+" genre with its short description";
    }

    //Method to get a book suggestion written in a specific language with a short description
    public String BookSuggestionLanguageQuery(String language){
        return "Suggest me a book written in the "+language+" language with its short description";
    }

    public String whoIsQuery(String name){
        return "who is "+name;
    }

    public String dictionaryQuery(String word){
        return "what is the meaning of "+word;
    }

    public String quoteQuery(){
        return "Display a popular quote.";
    }
}
