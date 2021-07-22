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

    @NotBlank(message = "ownerName.notBlank.message")
    @Column(length = 100)
    private String ownerName;

    @NotBlank(message = "companyName.notBlank.message")
    @Column(length = 100)
    private String companyName;

    @NotBlank(message = "companyAdress.notBlank.message")
    @Column(length = 100)
    private String companyAdress;

    @NotBlank(message = "city.notBlank.message")
    @Column(length = 100)
    private String city;

    @NotBlank(message = "country.notBlank.message")
    @Column(length = 100)
    private String country;

    @NotBlank(message = "companyPhone.notBlank.message")
    @Column(length = 100)
    private String companyPhone;

}
