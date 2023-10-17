package edu.icet.dto;

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
