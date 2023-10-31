package edu.icet.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeTM {
    private Integer empId;
    private String title;
    private String name;
    private String nic;
    private String dob;
    private String bankAccountNo;
    private String bankBranch;
    private String contact;
    private String address;
}
