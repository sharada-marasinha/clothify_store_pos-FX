package edu.icet.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Supplier {
    private Integer supplierId;
    private String title;
    private String supplierName;
    private String contact;
    private String company;
    private String email;
}
