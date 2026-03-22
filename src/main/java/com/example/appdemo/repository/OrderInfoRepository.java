package com.example.appdemo.repository;

import com.example.appdemo.entities.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderInfoRepository {

    @Autowired
    private ObjectMapper objectMapper;

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String ORDER_KEY = "orders";

    public OrderInfoRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public OrderInfo save(OrderInfo orderInfo) {
        orderInfo.setOrderDate(java.time.LocalDateTime.now());
        redisTemplate.opsForHash().put(ORDER_KEY, orderInfo.getOrderId(), orderInfo);
        return orderInfo;
    }

    public OrderInfo findById(String orderId) {
        Object object = redisTemplate.opsForHash().get(ORDER_KEY, orderId);
        if (object instanceof OrderInfo) {
            return (OrderInfo) object;
        }
        if (object instanceof Map) {
            return objectMapper.convertValue(object, OrderInfo.class);
        }
        return null;
    }

    public List<OrderInfo> findAll() {
        List<Object> values = redisTemplate.opsForHash().values(ORDER_KEY);
        List<OrderInfo> orders = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof OrderInfo) {
                orders.add((OrderInfo) value);
            }else if (value instanceof Map) {
                orders.add(objectMapper.convertValue(value, OrderInfo.class));
            }
        }
        return orders;
    }

    public OrderInfo update(OrderInfo orderInfo) {
//        orderInfo.setUpdateTime(java.time.LocalDateTime.now());
        redisTemplate.opsForHash().put(ORDER_KEY, orderInfo.getOrderId(), orderInfo);
        return orderInfo;
    }

    public boolean deleteById(String orderId) {
        return redisTemplate.opsForHash().delete(ORDER_KEY, orderId) > 0;
    }
}
