package entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sales_return")
public class SalesReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String returnId;
    private String orderId;
    private double total;
    private String date;
}
