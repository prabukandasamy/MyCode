package com.pk.h2test.beans;

import org.springframework.stereotype.Component;

@Component
//public class ProductRouter extends RouteBuilder {
public class ProductRouter {
	/*@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

		rest("/prod").consumes("application/json").produces("application/json").
				get("/view").outType(Product.class)
				.to("direct:viewProduct");

		from("direct:viewProduct").to("direct:products")
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400));

		
		 * process(exchange -> { Product p = new Product(); p.setName("Phone");
		 * p.setPrice("100"); exchange.getIn().setBody(p); });
		 
		
		 * .log(LoggingLevel.INFO, "Hello World") .transform().simple("Hello World");
		 
	}*/
}
