package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private String orderId;
    private String date;
    private double totalDiscount;
    private double total;
    private String empId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
}
