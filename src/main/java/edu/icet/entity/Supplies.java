package edu.icet.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Supplies {
    private String itemCode;
    private String description;
    private int qty;
}
