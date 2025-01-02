package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sales_return")
public class SalesReturn {
    private String returnId;
    private String orderId;
    private double total;
    private String date;
}
