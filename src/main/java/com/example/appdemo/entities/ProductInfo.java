package com.example.appdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String productId;       // 产品ID
    private String productName;     // 产品名称
    private Integer quantity;       // 购买数量
    private BigDecimal price;       // 单价
}
