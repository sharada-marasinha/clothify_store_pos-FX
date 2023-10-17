package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private String empId;
    private String title;
    private String name;
    private String nic;
    private String dob;
    private String bankAccountNo;
    private String bankBranch;
    private String contact;
    private String address;
}
