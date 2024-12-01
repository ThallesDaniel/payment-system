package com.thallesdaniel.paymentsystem.client;

import org.springframework.stereotype.Component;

import com.thallesdaniel.paymentsystem.dto.DebitPaymentRequest;

@Component
public class DebitClient {

    public boolean processarDebito(DebitPaymentRequest request) {
        // Simula o processamento de débito
        System.out.println("Processando débito para o cartão: " + request.getNumeroCartao());
        System.out.println("Nome do titular: " + request.getNomeTitular());
        System.out.println("Valor: R$ " + request.getValor());

        // Simula aprovação ou recusa
        return true; // ou false em caso de erro
    }
}