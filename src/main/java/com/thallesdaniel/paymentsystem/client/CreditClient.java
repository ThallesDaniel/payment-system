package com.thallesdaniel.paymentsystem.client;
import org.springframework.stereotype.Component;

import com.thallesdaniel.paymentsystem.dto.CreditPaymentRequest;

@Component
public class CreditClient {

    public boolean processarCredito(CreditPaymentRequest request) {
        // Simula o processamento de crédito
        System.out.println("Processando crédito para o cartão: " + request.getNumeroCartao());
        System.out.println("Nome do titular: " + request.getNomeTitular());
        System.out.println("Valor total: R$ " + request.getValor());
        System.out.println("Parcelas: " + request.getParcelas() + " de R$ " + (request.getValor() / request.getParcelas()));

        // Simula aprovação ou recusa
        return true; // ou false em caso de erro
    }
}