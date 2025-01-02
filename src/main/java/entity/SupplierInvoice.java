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
@Table(name = "supplier_invoice")
public class SupplierInvoice {
    private String invoiceId;
    private String supplierId;
    private String itemCode;
    private String date;
    private int qty;
}
