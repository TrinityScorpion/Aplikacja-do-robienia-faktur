package com.example.invoice;

import com.example.recipient.Recipient;
import com.example.sender.Sender;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = Invoice.TABLE_NAME)
@Data
public class Invoice {
    public static final String TABLE_NAME = "invoices";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "invoiceNumber.notBlank.message")
    @Column(length = 100)
    private String invoiceNumber;

    private LocalDate created;

    private LocalDate deadline;

    private int salary;

    private int quantity;

    private int tax;

    private String description;

    @ManyToOne
    private Recipient recipient;

    @ManyToOne
    private Sender sender;





}
