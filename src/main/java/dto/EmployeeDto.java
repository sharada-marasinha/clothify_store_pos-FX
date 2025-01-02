package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    private String name;
    private String title;
    private String nic;
    private String address;
    private String dob;
    private String contact;
    private String bankAccountNo;
    private String bankBranch;
}
