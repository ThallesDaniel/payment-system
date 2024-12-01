package com.thallesdaniel.paymentsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "credit_transactions")
public class CreditTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;
    private String nomeTitular;
    private Double valor;
    private Integer parcelas;
    private Double valorParcela;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private String status; 
}
