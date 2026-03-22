package com.example.appdemo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long Id;
//    private String userId;
    private String orderId;                // 订单ID
    private String orderName;               // 订单名称
//    private Double totalPrice;
//    private String status;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;        // 订单日期 (Java 8 时间类)

    private List<ProductInfo> products;     // 订单包含的产品列表 (嵌套对象)
    private LogisticsInfo logisticsInfo;    // 物流信息 (嵌套对象)
}
