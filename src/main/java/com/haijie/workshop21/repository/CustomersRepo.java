package com.haijie.workshop21.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haijie.workshop21.model.Customers;
import com.haijie.workshop21.model.Orders;

@Repository
public class CustomersRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    String selectSQL = "select * from customers limit ? offset ?";
    String selectIdSQL = "select * from customers where id = ?";
    String selectIdOrdersSQL = "select o.* from orders o inner join customers c on c.id = o.customer_id where o.customer_id=?";

    public List<Customers> findAll(Integer limit, Integer offset) {
        return jdbcTemplate.query(selectSQL, BeanPropertyRowMapper.newInstance(Customers.class), limit, offset);
    }

    public Customers findById(Integer id){
        return jdbcTemplate.queryForObject(selectIdSQL, BeanPropertyRowMapper.newInstance(Customers.class), id);
    }

    public List<Orders> findByIdOrders(Integer id){
        return jdbcTemplate.query(selectIdOrdersSQL, BeanPropertyRowMapper.newInstance(Orders.class), id);
    }
}
