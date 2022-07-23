package com.mvp.finances.application.controllers;

import com.mvp.finances.domain.contracts.TransactionService;
import com.mvp.finances.domain.dto.NewTransactionFormDto;
import com.mvp.finances.domain.dto.TransactionViewDto;
import com.mvp.finances.domain.dto.UpdateTransactionFormDto;
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


    @PostMapping
    public ResponseEntity<TransactionViewDto> create(@RequestBody NewTransactionFormDto transactionDto, UriComponentsBuilder uriBuilder){
        Transaction transaction = this.transactionService.create(transactionDto);
        URI ur = uriBuilder.path("/transactions/" + transaction.getId()).build().toUri();
        return ResponseEntity.created(ur).body(new TransactionViewDto(transaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionViewDto>> list() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionViewDto> update(@PathVariable("id") Long id, @RequestBody UpdateTransactionFormDto transactionDto) {
        Transaction transaction = this.transactionService.update(id, transactionDto);
        return ResponseEntity.ok(new TransactionViewDto(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionViewDto> delete(@PathVariable("id") Long id) {
        Transaction transaction = this.transactionService.delete(id);
        return ResponseEntity.ok(new TransactionViewDto(transaction));
    }
}
