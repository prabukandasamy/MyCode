package com.pk.h2test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pk.h2test.beans.Order;
import com.pk.h2test.beans.OrderList;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    // Saving a new Order
    public void saveOrder(Order order)
    {
        String sql = "insert into order_product(orderid,id,name,qty,price,purchase_date) values(?,?,?,?,?,CURRENT_DATE)";
        jdbcTemplate.update(sql, new Object[]
        {order.getOrderid(), order.getId(), order.getName(), Long.valueOf(order.getQty()), Long.valueOf(order.getPricetotal()) });
    }

    // Getting a particular Order
    public Order getOrderById(String id)
    {
    	Order order = null;
        String sql = "select orderid,id,name,qty,price from order_product where orderid=?";
        order = (Order) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper<Order>()
        {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	Order order = new Order();
            	order.setOrderid(rs.getString(1));
                order.setId(rs.getString(2));
                order.setName(rs.getString(3));
                order.setQty(rs.getString(4));
                order.setPricetotal(rs.getString(5));
                return order;
            }
        });
        if(order==null) {
        	order = new Order();
        }
        return order;
    }
    
    // Getting a particular Order
    public Order getOrderById(String orderid, String id)
    {
    	Order order = null;
        String sql = "select orderid,id,name,qty,price from order_product where orderid=? and id=?";
        order = (Order) jdbcTemplate.queryForObject(sql, new Object[]
        { orderid,id }, new RowMapper<Order>()
        {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	Order order = new Order();
            	order.setOrderid(rs.getString(1));
                order.setId(rs.getString(2));
                order.setName(rs.getString(3));
                order.setQty(rs.getString(4));
                order.setPricetotal(rs.getString(5));
                return order;
            }
        });
        if(order==null) {
        	order = new Order();
        }
        return order;
    }

    // Getting all the Orders
    public List<Order> getAllOrders(String orderid)
    {
        String sql = "select orderid,id,name,qty,price from order_product where orderid='"+orderid+"'";

        List<Order> orderList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Order>>()
        {
            public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Order> list = new ArrayList<Order>();
                while (rs.next())
                {
                	Order order = new Order();
                	order.setOrderid(rs.getString(1));
                    order.setId(rs.getString(2));
                    order.setName(rs.getString(3));
                    order.setQty(rs.getString(4));
                    order.setPricetotal(rs.getString(5));
                    list.add(order);
                }
                return list;
            }

        });
        return orderList;
    }
    
    public List<OrderList> getOrderList(String orderid)
    {
        String sql = "select distinct orderid,purchase_date,count(id),sum(price) from order_product where orderid like '%"+orderid+"%' group by orderid,purchase_date";

        List<OrderList> orderList = jdbcTemplate.query(sql, new ResultSetExtractor<List<OrderList>>()
        {
            public List<OrderList> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<OrderList> list = new ArrayList<OrderList>();
                while (rs.next())
                {
                	OrderList order = new OrderList();
                	order.setOrderid(rs.getString(1));
                    order.setPurchaseDate(rs.getString(2));
                    order.setQty(rs.getString(3));
                    order.setPricetotal(rs.getString(4));
                    list.add(order);
                }
                return list;
            }

        });
        return orderList;
    }

    // Updating a particular Order
    public void updateOrder(Order order)
    {
        String sql = "update order_product set name=?, qty=?,price=? where orderid=? and id=?";
        jdbcTemplate.update(sql, new Object[]
        { order.getName(), Long.valueOf(order.getQty()), Long.valueOf(order.getPricetotal()), order.getOrderid(), order.getId() });
    }

    // Deletion of a particular Order
    public void deleteOrder(String orderid, String id)
    {
        String sql = "delete from order_product where orderid=? and id=?";
        jdbcTemplate.update(sql, new Object[]
        { orderid,id });
    }

}
