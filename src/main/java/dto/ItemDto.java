package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private String itemCode;
    private String description;
    private int quantity;
    private double sellingPrice;
    private double buyingPrice;
    private String type;
    private String size;
    private String supplierId;
}
