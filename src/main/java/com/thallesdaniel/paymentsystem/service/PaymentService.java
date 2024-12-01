package com.thallesdaniel.paymentsystem.service;

import org.springframework.stereotype.Service;


import com.thallesdaniel.paymentsystem.client.DebitClient;
import com.thallesdaniel.paymentsystem.client.PixClient;
import com.thallesdaniel.paymentsystem.dto.DebitPaymentRequest;
import com.thallesdaniel.paymentsystem.dto.PixPaymentRequest;
import com.thallesdaniel.paymentsystem.entity.DebitTransaction;
import com.thallesdaniel.paymentsystem.entity.PixTransaction;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PixClient pixClient;
    
    private final DebitClient debitClient;

    public PaymentService(PixClient pixClient, 
                          DebitClient debitClient) {
        this.pixClient = pixClient;
        this.debitClient = debitClient;
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
 
    public DebitTransaction realizarPagamentoDebito(DebitPaymentRequest request) {
       
        DebitTransaction transaction = new DebitTransaction();
        transaction.setNumeroCartao(request.getNumeroCartao());
        transaction.setNomeTitular(request.getNomeTitular());
        transaction.setValor(request.getValor());
        transaction.setDataCriacao(LocalDateTime.now());

        boolean aprovado = debitClient.processarDebito(request);

        transaction.setStatus(aprovado ? "APROVADO" : "RECUSADO");
        return transaction;
    }
}

