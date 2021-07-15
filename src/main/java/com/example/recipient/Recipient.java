package com.example.recipient;

import com.example.invoice.Invoice;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Recipient.TABLE_NAME)
@Data
public class Recipient {

    public static final String TABLE_NAME = "recipients";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "recipientName.notBlank.message")
    @Column(length = 100)
    private String recipientName;

    @NotBlank(message = "recipientCompany.notBlank.message")
    @Column(length = 100)
    private String recipientCompany;

    @NotBlank(message = "recipientCity.notBlank.message")
    @Column(length = 100)
    private String recipientCity;
}
