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
@Table(name = "payment")
public class Payment {
    private String paymentId;
    private double cash;
    private double balance;
    private String date;
    private boolean isPayByCash;
    private String orderId;
}
