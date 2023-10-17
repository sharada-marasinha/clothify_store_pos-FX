package edu.icet.dto;

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
