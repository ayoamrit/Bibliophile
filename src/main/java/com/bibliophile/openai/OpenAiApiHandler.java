package com.bibliophile.openai;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import io.github.cdimascio.dotenv.Dotenv;
import com.theokanning.openai.service.OpenAiService;

public class OpenAiApiHandler {

    private final Dotenv dotenv = Dotenv.configure().directory("ref/.env").load();

    /**
     * This method takes a prompt as input and return completion request after getting
     * that from the OpenAiApi
     * @param prompt the prompt for which a completion request is required
     * @return the completion request as a String
     */
    public String getPrompt(String prompt){

        //Call getCompletionRequest() method to get the completion request for the prompt
        return getCompletionRequest(prompt);
    }

    //create method to get API key of the OpenAiApi
    private String getApiKey(){
        return dotenv.get("API");
    }

    //create method to get model of the OpenAiApi
    private String getApiModel(){
        return dotenv.get("MODEL");
    }

    //create a method to get and OpenAiService object using API key
    private OpenAiService getService(){
        try {
            return new OpenAiService(getApiKey());
        }catch(Exception e){
            //If an exception is thrown
            //Return null to indicate that the connection to the OpenAI API was unsuccessful
            return null;
        }
    }

    //create a method to get the completion request for a given prompt using the OpenAI
    private String getCompletionRequest(String prompt){

        try {
            //Get the OpenAiService object using the getService() method
            OpenAiService service = getService();

            //Check if the service is null, which indicates that the connection to the OpenAI
            //API was unsuccessful
            if (service == null) {

                //return null when the OpenAiService is null
                return null;
            }

            //Build the completion request using the given prompt and model
            CompletionRequest completionRequest = CompletionRequest.builder()
                    //Request sent by the user to the API
                    .prompt(prompt)

                    //Using model to get the best result according to the request
                    //of the user
                    .model(getApiModel())

                    //Tokens are pieces of words used for natural language processing.
                    //For text in English, 1 token is approx. 4 characters or 0.75 words
                    .maxTokens(1500)

                    //Temperature is a value that control confident the model should be
                    //when making predictions. Lower temperature means it will take fewer risks, and
                    //completions will be more accurate. Increasing temperature will result in more
                    //diverse completions
                    .temperature(1.3)

                    //building CompletionRequest
                    .build();

            //Call the createCompletion() method on the OpenAiService object to get
            //the completion result
            CompletionResult completionResult = service.createCompletion(completionRequest);
            //Get choices from the completion result and convert them to a string
            String result = String.valueOf(completionResult.getChoices().get(0).getText());

            //return the completion result as a string
            return result;
        }
        catch(Exception e){
            return "An error occurred while completion of the result.";
        }
    }

}
