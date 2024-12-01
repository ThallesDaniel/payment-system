package com.thallesdaniel.paymentsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thallesdaniel.paymentsystem.dto.PixPaymentRequest;
import com.thallesdaniel.paymentsystem.entity.PixTransaction;
import com.thallesdaniel.paymentsystem.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {
        private final PaymentService paymentService;

    public TransferController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pix")
    public ResponseEntity<PixTransaction> realizarPagamentoPix(@Valid @RequestBody PixPaymentRequest request) {
        PixTransaction transaction = paymentService.realizarPagamento(request);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
