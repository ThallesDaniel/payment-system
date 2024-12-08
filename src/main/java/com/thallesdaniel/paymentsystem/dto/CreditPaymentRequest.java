package com.thallesdaniel.paymentsystem.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class CreditPaymentRequest {
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

    @NotNull(message = "O campo 'parcelas' é obrigatório.")
    @Min(value = 1, message = "O número mínimo de parcelas é 1.")
    @Max(value = 12, message = "O número máximo de parcelas é 12.")
    private Integer parcelas;
}
