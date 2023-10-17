package edu.icet.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private int id;
    private String user_name;
    private String email;
    private String password;
    private String user_type;
}
