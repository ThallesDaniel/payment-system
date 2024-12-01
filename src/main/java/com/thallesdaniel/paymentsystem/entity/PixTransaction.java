package com.thallesdaniel.paymentsystem.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pix_transactions")
public class PixTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chavePixDestinatario;
    private Double valor;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private String status; // Exemplo: SUCESSO, FALHA
}