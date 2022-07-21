package com.mvp.finances.application.controllers;

import com.mvp.finances.domain.contracts.TransactionService;
import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.dto.TransactionViewDto;
import com.mvp.finances.domain.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> list() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @PostMapping
    public ResponseEntity<TransactionViewDto> create(@RequestBody NewTransactionFormDto transactionDto, UriComponentsBuilder uriBuilder){
        Transaction transaction = this.transactionService.create(transactionDto.toModel());
        URI ur = uriBuilder.path("/transactions/" + transaction.getId()).build().toUri();
        return ResponseEntity.created(ur).body(new TransactionViewDto(transaction));
    }
}
