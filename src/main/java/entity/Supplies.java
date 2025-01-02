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
@Table(name = "supplies")
public class Supplies {
    private String itemCode;
    private String description;
    private int qty;
}
