package com.github.fenxlol.listofpayments.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer paymentNumber;
    private Double amount;
    private Date paymentDate;

    @Transient
    @JsonBackReference
    Credit credit;

}
