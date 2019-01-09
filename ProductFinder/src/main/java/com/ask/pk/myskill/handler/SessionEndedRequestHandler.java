package com.ask.pk.myskill.handler;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;
import com.amazon.ask.request.Predicates;

public class SessionEndedRequestHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(SessionEndedRequest.class));
    }

    public Optional<Response> handle(HandlerInput input) {
        //any cleanup logic goes here
        return input.getResponseBuilder().build();
    }
}
