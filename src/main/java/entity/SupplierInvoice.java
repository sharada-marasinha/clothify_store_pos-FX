package entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "supplier_invoice")
public class SupplierInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String invoiceId;
    private String supplierId;
    private String itemCode;
    private String date;
    private int qty;
}
