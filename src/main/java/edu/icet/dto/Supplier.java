package edu.icet.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Supplier {
    private String supplierId;
    private String title;
    private String supplierName;
    private String contact;
    private String company;
    private String email;
}
