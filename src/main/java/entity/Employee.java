package entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
