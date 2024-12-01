package com.thallesdaniel.paymentsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DebitPaymentRequest {
    @NotBlank(message = "O campo 'numeroCartao' é obrigatório.")
    private String numeroCartao;

    @NotBlank(message = "O campo 'nomeTitular' é obrigatório.")
    private String nomeTitular;

    @NotBlank(message = "O campo 'dataValidade' é obrigatório.")
    private String dataValidade; // Formato MM/AA

    @NotBlank(message = "O campo 'codigoSeguranca' é obrigatório.")
    private String codigoSeguranca;

    @NotNull(message = "O campo 'valor' é obrigatório.")
    @Positive(message = "O valor deve ser maior que zero.")
    private Double valor;
}