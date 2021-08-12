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

    @NotBlank(message ="No owner name")
    @Column(length = 100)
    private String ownerName;

    @NotBlank(message = "No company name")
    @Column(length = 100)
    private String companyName;

    @NotBlank(message = "No company adress")
    @Column(length = 100)
    private String companyAdress;

    @NotBlank(message = "No city")
    @Column(length = 100)
    private String city;

    @NotBlank(message = "No country")
    @Column(length = 100)
    private String country;

    @NotBlank(message = "No company phone")
    @Column(length = 100)
    private String companyPhone;

}
