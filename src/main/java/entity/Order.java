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
@Table(name = "order")
public class Order {
    private String orderId;
    private String date;
    private double totalDiscount;
    private double total;
    private String empId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
}
