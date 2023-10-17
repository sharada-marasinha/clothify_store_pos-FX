package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private double totalProfit;
    private double discount;
}
