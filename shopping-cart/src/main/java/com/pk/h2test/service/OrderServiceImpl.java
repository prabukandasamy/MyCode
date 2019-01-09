package com.pk.h2test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.h2test.beans.Order;
import com.pk.h2test.beans.OrderList;
import com.pk.h2test.dao.OrderDAO;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDAO orderDao;

	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}

	@Override
	public Order getOrderById(String id) {
		return orderDao.getOrderById(id);
	}
	
	@Override
	public Order getOrderById(String orderid,String id) {
		return orderDao.getOrderById(orderid,id);
	}

	@Override
	public void updateOrder(Order Order) {
		orderDao.updateOrder(Order);
	}

	@Override
	public void deleteOrder(String orderid, String id) {
		orderDao.deleteOrder(orderid,id);
	}

	@Override
	public List<Order> getAllOrders(String orderid) {
		return orderDao.getAllOrders(orderid);
	}

	@Override
	public List<OrderList> getOrderList(String orderid) {
		
		return  orderDao.getOrderList(orderid);
	}
	
	
}
