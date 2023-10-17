package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private String id;
    private String email;
    private String password;
    private int user_type;
}
