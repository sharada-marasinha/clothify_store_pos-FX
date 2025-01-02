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
@Table(name = "user")
public class User {
    private int id;
    private String user_name;
    private String email;
    private String password;
    private String user_type;
}
