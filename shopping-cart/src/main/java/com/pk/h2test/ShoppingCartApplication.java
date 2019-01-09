package com.pk.h2test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ShoppingCartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
	
	/*@Bean
	  public ServletRegistrationBean camelServletRegistrationBean() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel/*");
	    registration.setName("CamelServlet");
	    return registration;
	  }*/

}
