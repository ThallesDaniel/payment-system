package com.thallesdaniel.paymentsystem.service;

import org.springframework.stereotype.Service;

import com.thallesdaniel.paymentsystem.client.CreditClient;
import com.thallesdaniel.paymentsystem.client.DebitClient;
import com.thallesdaniel.paymentsystem.client.PixClient;
import com.thallesdaniel.paymentsystem.dto.CreditPaymentRequest;
import com.thallesdaniel.paymentsystem.dto.DebitPaymentRequest;
import com.thallesdaniel.paymentsystem.dto.PixPaymentRequest;
import com.thallesdaniel.paymentsystem.entity.CreditTransaction;
import com.thallesdaniel.paymentsystem.entity.DebitTransaction;
import com.thallesdaniel.paymentsystem.entity.PixTransaction;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PixClient pixClient;
    
    private final DebitClient debitClient;

    private final CreditClient creditClient;

    public PaymentService(PixClient pixClient, 
                          DebitClient debitClient,
                          CreditClient creditClient) {
        this.pixClient = pixClient;
        this.debitClient = debitClient;
        this.creditClient = creditClient;
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

     public CreditTransaction realizarPagamentoCredito(CreditPaymentRequest request) {
        // Calcula o valor da parcela
        Double valorParcela = request.getValor() / request.getParcelas();

        // Cria uma transação
        CreditTransaction transaction = new CreditTransaction();
        transaction.setNumeroCartao(request.getNumeroCartao());
        transaction.setNomeTitular(request.getNomeTitular());
        transaction.setValor(request.getValor());
        transaction.setParcelas(request.getParcelas());
        transaction.setValorParcela(valorParcela);
        transaction.setDataCriacao(LocalDateTime.now());

        // Envia para o cliente de crédito
        boolean aprovado = creditClient.processarCredito(request);

        // Atualiza o status
        transaction.setStatus(aprovado ? "APROVADO" : "RECUSADO");
        return transaction;
    }
}

