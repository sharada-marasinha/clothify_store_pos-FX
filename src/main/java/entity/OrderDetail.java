package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private double totalProfit;
    private double discount;
}
