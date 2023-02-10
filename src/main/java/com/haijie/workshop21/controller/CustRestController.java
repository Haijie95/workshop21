package com.haijie.workshop21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.haijie.workshop21.repository.CustomersRepo;
import java.util.List;
import com.haijie.workshop21.model.Customers;
import com.haijie.workshop21.model.Orders;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("")
public class CustRestController {
    
    @Autowired
    CustomersRepo custRepo;

    @GetMapping(path = "api/customers", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customers>> getCustomers(@RequestParam(defaultValue = "5") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset) {
        List<Customers> cList = custRepo.findAll(limit, offset);

        if (cList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cList, HttpStatus.OK);
        }
    }

    @GetMapping(path="api/customers/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id){
        Customers cust = custRepo.findById(id);

        if (cust ==  null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cust, HttpStatus.OK);
        }
    }

    @GetMapping(path="api/customers/{id}/orders", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Orders>> getOrdersById(@PathVariable Integer id){
        List<Orders> oList = custRepo.findByIdOrders(id);

        if (oList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(oList, HttpStatus.OK);
        }
    }
}
