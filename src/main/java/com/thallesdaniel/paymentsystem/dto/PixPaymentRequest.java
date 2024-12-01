package com.thallesdaniel.paymentsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PixPaymentRequest {

    @NotBlank(message = "O campo 'chavePixDestinatario' é obrigatório.")
    private String chavePixDestinatario;

    @NotNull(message = "O campo 'valor' é obrigatório.")
    @Positive(message = "O valor deve ser maior que zero.")
    private Double valor;

    @NotBlank(message = "O campo 'descricao' é obrigatório.")
    private String descricao;
}
