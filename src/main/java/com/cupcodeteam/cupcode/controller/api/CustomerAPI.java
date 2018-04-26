package com.cupcodeteam.cupcode.controller.api;

import com.cupcodeteam.cupcode.entity.Customer;
import com.cupcodeteam.cupcode.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
@RestController
@RequestMapping("/api")
public class CustomerAPI {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/get_customer")
    public List<Customer> getCustomerList(){
        List<Customer> customer = this.customerRepository.findAll();

        return customer;
    }
}
