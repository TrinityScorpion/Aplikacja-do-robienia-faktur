package com.example.invoice;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = Invoice.TABLE_NAME)
@Data
public class Invoice {
    public static final String TABLE_NAME = "invoices";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "invoiceNumber.notBlank.message")
    @Column(length = 100)
    private String invoiceNumber;

    @NotBlank(message = "created.notBlank.message")
    private LocalDate created;

    @NotBlank(message = "deadline.notBlank.message")
    private LocalDate deadline;





}
