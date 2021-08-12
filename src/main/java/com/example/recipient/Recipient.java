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

    @NotBlank(message = "No recipient name")
    @Column(length = 100)
    private String recipientName;

    @NotBlank(message = "No company")
    @Column(length = 100)
    private String recipientCompany;

    @NotBlank(message = "No city")
    @Column(length = 100)
    private String recipientCity;

    @NotBlank(message = "No country")
    @Column(length = 100)
    private String recipientCountry;
}
