package com.example.appdemo.controller;

import com.example.appdemo.entities.OrderInfo;
import com.example.appdemo.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderInfo> createOrder(@Valid @RequestBody OrderInfo orderInfo) {
        OrderInfo createdOrder = orderService.createOrder(orderInfo);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderInfo> getOrderById(@PathVariable String id) {
        OrderInfo orderInfo = orderService.getOrderById(id);
        if (orderInfo != null) {
            return new ResponseEntity<>(orderInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderInfo>> getAllOrders() {
        List<OrderInfo> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderInfo> updateOrder(@Valid @RequestBody OrderInfo orderInfo) {
        OrderInfo updatedOrder = orderService.updateOrder(orderInfo);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        boolean deleted = orderService.deleteOrder(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
