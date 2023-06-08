package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public Customer sayHello(){
        Customer customer = new Customer(1L, "John", "Doe", "dasda@asda");
        return customer;
    }

}
