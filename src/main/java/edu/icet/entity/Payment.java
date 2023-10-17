package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private String paymentId;
    private double cash;
    private double balance;
    private String date;
    private boolean isPayByCash;
    private String orderId;
}
