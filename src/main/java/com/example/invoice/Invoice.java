package com.example.invoice;

import com.example.recipient.Recipient;
import com.example.sender.Sender;
import com.example.user.User;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

//@ExceptionHandler(MethodArgumentNotValidException)
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

    @Min(value = 1, message = "Salary should be bigger than 1")
    private int salary;

    @Min(value = 1, message = "Quantity should be bigger than 1")
    private int quantity;

    @Min(value = 1, message = "Tax should be bigger than 1")
    private int tax;

    @NotBlank(message = "No description")
    private String description;

    @ManyToOne
    @NotNull(message = "Choose recipient")
    private Recipient recipient;

    @ManyToOne
    @NotNull(message = "Choose Sender")
    private Sender sender;

    @ManyToOne
    private User user;

}
