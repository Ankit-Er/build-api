package com.example.demo.controller;

import com.example.demo.classes.CreateOrder;
import com.example.demo.classes.RespOrder;
import com.example.demo.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class HomeController {

    @Autowired
    private ServiceLayer serviceLayer;

    @PostMapping("/create")
    public String createOrder(@RequestBody List<CreateOrder> orderItem) {
        return serviceLayer.saveItems(orderItem);
    }

    @GetMapping("/")
    public ResponseEntity<List<RespOrder>> getOrder() {
        return new ResponseEntity<>(serviceLayer.getOrders(),HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<RespOrder> getOrder(@PathVariable("orderId") int orderId) {
        return new ResponseEntity<RespOrder>(serviceLayer.getOrder(orderId), HttpStatus.OK);
    }
}
