package com.pk.h2test.service;

import java.util.List;

import com.pk.h2test.beans.Order;
import com.pk.h2test.beans.OrderList;

public interface OrderService {
	
	public void saveOrder(Order order);
    public Order getOrderById(String id);
    public void updateOrder(Order order);
    public void deleteOrder(String orderid, String id);
    public List<Order> getAllOrders(String orderid);
    public Order getOrderById(String orderid, String id);
    public List<OrderList> getOrderList(String orderid);

}
