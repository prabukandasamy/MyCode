package com.ask.pk.myskill.handler;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class LaunchRequestHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.requestType(LaunchRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Hey!! Welcome to P K super market. I can help to find product location and availablity. Tell me the product name";
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard("ProductMap", speechText)
				.withReprompt(speechText).build();
	}

}
