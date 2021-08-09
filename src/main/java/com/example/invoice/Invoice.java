package com.example.invoice;

import com.example.recipient.Recipient;
import com.example.sender.Sender;
import com.example.user.User;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = Invoice.TABLE_NAME)
@Data
public class Invoice {
    public static final String TABLE_NAME = "invoices";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String invoiceNumber;

    private LocalDate created;

    private LocalDate deadline;

    @NotNull(message = "salary.notBlank.message")
    private int salary;

    @NotNull(message = "invoice.quantity.notblank")
    private int quantity;

    @NotNull(message = "invoice.tax.notblank")
    private int tax;

    @NotBlank(message = "description.notBlank.message")
    private String description;

    @ManyToOne
    @NotNull(message = "invoice.recipient.notblank")
    private Recipient recipient;

    @ManyToOne
    @NotNull(message = "invoice.sender.notblank")
    private Sender sender;

    @ManyToOne
    private User user;



}
