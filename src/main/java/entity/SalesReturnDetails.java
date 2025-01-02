package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sales_return_details")
public class SalesReturnDetails {
    private String returnId;
    private String itemCode;
    private int qty;
    private double discount;
    private double unitPrice;
    private double amount;
}
