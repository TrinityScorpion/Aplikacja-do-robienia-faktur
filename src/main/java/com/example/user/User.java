package com.example.user;

import com.example.invoice.Invoice;
import com.example.role.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;

    @Email
    private String email;

    @Transient
    private String confirmPassword;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;




}
