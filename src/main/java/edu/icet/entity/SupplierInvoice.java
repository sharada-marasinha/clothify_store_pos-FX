package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SupplierInvoice {
    private String invoiceId;
    private String supplierId;
    private String itemCode;
    private String date;
    private int qty;
}
