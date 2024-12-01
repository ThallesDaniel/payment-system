package com.thallesdaniel.paymentsystem.service;

import org.springframework.stereotype.Service;

import com.thallesdaniel.paymentsystem.client.PixClient;
import com.thallesdaniel.paymentsystem.dto.PixPaymentRequest;
import com.thallesdaniel.paymentsystem.entity.PixTransaction;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PixClient pixClient;

    public PaymentService(PixClient pixClient) {
        this.pixClient = pixClient;
    }

    public PixTransaction realizarPagamento(PixPaymentRequest request) {
        // Cria uma transação
        PixTransaction transaction = new PixTransaction();
        transaction.setChavePixDestinatario(request.getChavePixDestinatario());
        transaction.setValor(request.getValor());
        transaction.setDescricao(request.getDescricao());
        transaction.setDataCriacao(LocalDateTime.now());

        // Envia para o cliente PIX
        boolean sucesso = pixClient.enviarPix(request);

        // Atualiza o status
        transaction.setStatus(sucesso ? "SUCESSO" : "FALHA");
        return transaction;
    }
}