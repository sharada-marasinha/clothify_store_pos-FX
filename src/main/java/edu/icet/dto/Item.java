package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Item {
    private String itemCode;
    private String description;
    private int quantity;
    private double sellingPrice;
    private double buyingPrice;
    private String type;
    private String size;
    private String supplierId;
}
