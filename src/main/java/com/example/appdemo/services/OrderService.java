package com.example.appdemo.services;

import com.example.appdemo.entities.OrderInfo;
import com.example.appdemo.repository.OrderInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderInfoRepository orderInfoRepository;

    public OrderInfo createOrder(OrderInfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }

    public OrderInfo getOrderById(String orderId) {
        return orderInfoRepository.findById(orderId);
    }

    public List<OrderInfo> getAllOrders() {
        return orderInfoRepository.findAll();
    }

    public OrderInfo updateOrder(OrderInfo orderInfo) {
        return orderInfoRepository.update(orderInfo);
    }

    public boolean deleteOrder(String orderId) {
        return orderInfoRepository.deleteById(orderId);
    }
}
