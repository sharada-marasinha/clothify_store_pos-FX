package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "supplier")
public class Supplier {
    private Integer supplierId;
    private String title;
    private String supplierName;
    private String contact;
    private String company;
    private String email;
}
