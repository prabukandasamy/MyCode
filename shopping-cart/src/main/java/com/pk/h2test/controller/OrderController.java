package com.pk.h2test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.h2test.beans.Order;
import com.pk.h2test.beans.OrderList;
import com.pk.h2test.entity.Product;
import com.pk.h2test.exception.ResourceNotFoundException;
import com.pk.h2test.request.ProductRequest;
import com.pk.h2test.service.OrderService;
import com.pk.h2test.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order, Model model) throws ResourceNotFoundException {
		try {
			if (orderService.getOrderById(order.getOrderid(), order.getId()) != null) {
				orderService.updateOrder(order);
			}
		} catch (EmptyResultDataAccessException e) {
			orderService.saveOrder(order);
		}
		List<Order> orderList = orderService.getAllOrders(order.getOrderid());

		for (Order tmporder : orderList) {
			Product prod = productService.getProductById(tmporder.getId());
			tmporder.setPrice(String.valueOf(prod.getPrice()));
		}
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		model.addAttribute("order", new Order(order.getOrderid(),"","","","",""));
		model.addAttribute("orders", orderList);

		return "orderProduct";

	}

	private long getPayTotal(List<Order> orderList) {
		long payAmount = 0;
		for (Order tmporder : orderList) {
			payAmount = payAmount + Long.valueOf(tmporder.getPricetotal());
		}

		return payAmount;

	}

	@RequestMapping(value = "/editorder/{orderid}/{id}")
	public String editOrder(Model model, ProductRequest request) throws ResourceNotFoundException {
		Order order = orderService.getOrderById(request.getOrderid(), request.getId());
		Product prod = productService.getProductById(order.getId());
		order.setPrice(String.valueOf(prod.getPrice()));
		List<Order> orderList = orderService.getAllOrders(request.getOrderid());
		for (Order tmporder : orderList) {
			Product product = productService.getProductById(tmporder.getId());
			tmporder.setPrice(String.valueOf(product.getPrice()));
		}
		model.addAttribute("order", order);
		model.addAttribute("orders", orderList);
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		return "orderProduct";

	}

	@RequestMapping(value = "/deleteorder/{orderid}/{id}")
	public String deleteOrder(ProductRequest request, Model model) throws ResourceNotFoundException {
		orderService.deleteOrder(request.getOrderid(), request.getId());

		List<Order> orderList = orderService.getAllOrders(request.getOrderid());

		for (Order tmporder : orderList) {
			Product prod = productService.getProductById(tmporder.getId());
			tmporder.setPrice(String.valueOf(prod.getPrice()));
		}
		model.addAttribute("order", new Order(request.getOrderid(),"","","","",""));
		model.addAttribute("orders", orderList);
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		return "orderProduct";

	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String listOrders(Model model) {

		Order order = new Order();
		
		String orderId = generateOrderId();
		model.addAttribute("order", order);
		order.setOrderid(orderId);
		List<Order> orderList = new ArrayList<Order>();
		model.addAttribute("orders", orderList);
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		return "orderProduct";
	}
	
	@RequestMapping(value = "/orders/{orderid}")
	public String listOrder(Model model, ProductRequest request) throws ResourceNotFoundException {

		Order order = new Order();
		order.setOrderid(request.getOrderid());
		model.addAttribute("order", order);
		List<Order> orderList = orderService.getAllOrders(request.getOrderid());
		for (Order tmporder : orderList) {
			Product product = productService.getProductById(tmporder.getId());
			tmporder.setPrice(String.valueOf(product.getPrice()));
		}
		model.addAttribute("orders", orderList);
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		return "orderProduct";
	}

	@RequestMapping(value = "/populateorder/{id}")
	public String populateOrderData(@PathVariable("id") String id, Model model, @ModelAttribute("order") Order order) throws ResourceNotFoundException {
		Product prod = productService.getProductById(id);
		if (prod == null) {
			return "productList";
		}
		order.setName(prod.getName());
		order.setPrice(String.valueOf(prod.getPrice()));
		model.addAttribute("order", order);

		List<Order> orderList = orderService.getAllOrders(order.getOrderid());
		for (Order tmporder : orderList) {
			Product product = productService.getProductById(tmporder.getId());
			tmporder.setPrice(String.valueOf(product.getPrice()));
		}
		model.addAttribute("orders", orderList);
		long payAmt = getPayTotal(orderList);
		model.addAttribute("payAmount", payAmt);
		return "orderProduct";
	}
	
	private String generateOrderId() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
		String str = sdf.format(date);
		return str;
	}
	
	@RequestMapping("/paybill")
	public String checkout() {
		return "checkout";
	}
	
	@RequestMapping("/orderlist")
	public String orderList(Model model) {
		model.addAttribute("order", new OrderList());
		model.addAttribute("orderlist", new ArrayList<OrderList>());
		return "orderlist";
	}
	
	@RequestMapping(value ="/orderlist/{orderid}")
	public String orderList(@PathVariable("orderid") String id,Model model) {
		List<OrderList> orderList = orderService.getOrderList(id);
		model.addAttribute("order", new OrderList());
		model.addAttribute("orderList", orderList);
		return "orderlist";
	}

}
