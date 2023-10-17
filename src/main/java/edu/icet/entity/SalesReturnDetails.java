package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SalesReturnDetails {
    private String returnId;
    private String itemCode;
    private int qty;
    private double discount;
    private double unitPrice;
    private double amount;
}
