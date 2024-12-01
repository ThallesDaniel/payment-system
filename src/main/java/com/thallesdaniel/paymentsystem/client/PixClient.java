package com.thallesdaniel.paymentsystem.client;

import org.springframework.stereotype.Component;

import com.thallesdaniel.paymentsystem.dto.PixPaymentRequest;

@Component
public class PixClient {

    public boolean enviarPix(PixPaymentRequest request) {
        // Simulação de envio para o sistema PIX (em produção, integre com APIs do banco de preferencia ou com aa propria api.)
        System.out.println("Enviando PIX para chave: " + request.getChavePixDestinatario());
        System.out.println("Valor: R$ " + request.getValor());
        System.out.println("Descrição: " + request.getDescricao());

        // Simula sucesso ou falha
        return true; // ou false em caso de erro
    }
}