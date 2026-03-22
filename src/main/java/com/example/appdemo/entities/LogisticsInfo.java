package com.example.appdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogisticsInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String logisticsCompany;   // 物流公司
    private String trackingNumber;     // 运单号
    private String receiverAddress;    // 收货地址
    private String receiverPhone;      // 收货人电话
    private String status;             // 物流状态 (例如：已发货、运输中、已签收)
}
