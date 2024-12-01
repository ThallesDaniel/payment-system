package com.thallesdaniel.paymentsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "debit_transactions")
public class DebitTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;
    private String nomeTitular;
    private Double valor;
    private LocalDateTime dataCriacao;

    private String status; // Exemplo: APROVADO, RECUSADO
}