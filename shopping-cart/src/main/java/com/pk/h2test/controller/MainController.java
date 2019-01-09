package com.pk.h2test.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pk.h2test.utils.WebUtils;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }
	
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
    public ModelAndView index(Principal principal) {
		String page = ""; 
		if (principal != null) {
	            User loginedUser = (User) ((Authentication) principal).getPrincipal();
	            String userInfo = WebUtils.toString(loginedUser);
	            System.out.println(userInfo);
	            if(userInfo.contains("ROLE_ADMIN")) {
	            	page = "products";
	            }else {
	            	page = "orders";
	            }
	            
		 }
		
		
		return new ModelAndView("redirect:/"+page);
    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
}
