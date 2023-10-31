package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {
    private String orderId;
    private String date;
    private double totalDiscount;
    private double total;
    private String empId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
}
