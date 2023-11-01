package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    private String title;
    private String name;
    private String nic;
    private String dob;
    private String bankAccountNo;
    private String bankBranch;
    private String contact;
    private String address;
}
