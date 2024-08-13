package com.bookManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bookManagement.model.Order;
import com.bookManagement.model.PlaceOrderRequest;
import com.bookManagement.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody PlaceOrderRequest request) {
        return orderService.placeOrder(request);
    }
    
    @GetMapping("/{username}")
    public List<Order> getUserOrderHistory(@PathVariable String username) {
        return orderService.getUserOrderHistory(username);
    }
}

