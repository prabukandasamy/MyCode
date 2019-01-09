package com.ask.pk.myskill.handler;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class HelpIntentHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("AMAZON.HelpIntent"));
    }

    public Optional<Response> handle(HandlerInput input) {
        String speechText = "You can ask me about product details that available in our shop, I can tell you the product location and availablity. Ask me like where can I get with product name";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("ProductMap", speechText)
                .withReprompt(speechText)
                .build();
    }
}
