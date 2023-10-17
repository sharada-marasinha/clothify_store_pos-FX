package edu.icet.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SalesReturn {
    private String returnId;
    private String orderId;
    private double total;
    private String date;
}
