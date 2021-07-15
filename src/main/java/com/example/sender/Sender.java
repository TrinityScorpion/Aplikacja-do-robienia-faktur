package com.example.sender;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Sender.TABLE_NAME)
@Data
public class Sender {
    public static final String TABLE_NAME = "senders";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "companyName.notBlank.message")
    @Column(length = 100)
    private String companyName;

    @NotBlank(message = "companyAdress.notBlank.message")
    @Column(length = 100)
    private String companyAdress;

    @NotBlank(message = "city.notBlank.message")
    @Column(length = 100)
    private String city;

}
