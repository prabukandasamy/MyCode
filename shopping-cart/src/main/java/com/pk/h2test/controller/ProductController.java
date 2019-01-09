package com.pk.h2test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pk.h2test.entity.Product;
import com.pk.h2test.exception.ResourceNotFoundException;
import com.pk.h2test.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/addProduct",method=RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) throws ResourceNotFoundException
    {
        productService.saveProduct(product);
        return new ModelAndView("redirect:/products");
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editProduct(Model model,@PathVariable("id") String id) throws ResourceNotFoundException
    {
        Product product = productService.getProductById(id);
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("product", product);
        model.addAttribute("products", productList);
        return "productList";
        
    }
    
    
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteProduct(@ModelAttribute("product") Product employee,@PathVariable("id") String id) throws ResourceNotFoundException
    {
    	productService.deleteProduct(id);
        
        return new ModelAndView("redirect:/products");
    }

    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model)
    {
    	
    	 Product product = new Product();
         model.addAttribute("product", product);

        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "productList";
    }
	
}
