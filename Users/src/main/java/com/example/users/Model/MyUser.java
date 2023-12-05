package com.example.users.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "please enter name")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @NotEmpty(message = "please enter UserName")
    @Column(columnDefinition ="varchar(40) not null unique")
    private String userName;
    @NotEmpty(message = "please enter password")
    private String password;
    @Email
    @NotEmpty(message = "please enter email")
    @Column(columnDefinition ="varchar(40)not null unique")
    private String email;
    @NotEmpty(message = "please enter role user or admin")
    @Column(columnDefinition = "varchar(6) check(role ='user' or role = 'admin')")
    private String role;
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer age;
}
