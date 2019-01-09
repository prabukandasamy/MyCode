package com.ask.pk.myskill;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.ask.pk.myskill.handler.CancelandStopIntentHandler;
import com.ask.pk.myskill.handler.FallbackIntentHandler;
import com.ask.pk.myskill.handler.HelpIntentHandler;
import com.ask.pk.myskill.handler.LaunchRequestHandler;
import com.ask.pk.myskill.handler.ProductMapIntentHandler;
import com.ask.pk.myskill.handler.SessionEndedRequestHandler;
import com.amazon.ask.SkillStreamHandler;

public class ProductMapStreamHandler extends SkillStreamHandler {

    @SuppressWarnings("unchecked")
	private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                       new CancelandStopIntentHandler(),
                       new ProductMapIntentHandler(),
                       new HelpIntentHandler(),
                       new LaunchRequestHandler(),
                       new SessionEndedRequestHandler(),
                       new FallbackIntentHandler())
                // Add your skill id below
                .withSkillId("amzn1.ask.skill.83933aca-dd40-4ddd-8d76-55f68ee4544d")
                .build();
              
    }

    public ProductMapStreamHandler() {
        super(getSkill());
    }

}
