package com.mvp.finances.application.controllers;

import com.mvp.finances.domain.dto.*;
import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.services.TransactionService;
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
    public ResponseEntity<TransactionViewDto> create(@RequestBody NewTransactionFormDto transactionDto, UriComponentsBuilder uriBuilder) {
        Transaction transaction = this.transactionService.create(transactionDto);
        URI ur = uriBuilder.path("/transactions/" + transaction.getId()).build().toUri();
        return ResponseEntity.created(ur).body(new TransactionViewDto(transaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionViewDto>> list() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/report")
    public ResponseEntity<List<TransactionReportByDate>> report(
            @RequestParam(name = "type") ReleaseType releaseType,
            @RequestParam(name = "year") Integer year
    ) {
        return ResponseEntity.ok(this.transactionService.reportByYear(releaseType, year));
    }

    @GetMapping("/report/category")
    public ResponseEntity<List<TransactionReportByCategory>> report_category(
            @RequestParam(name = "type") ReleaseType releaseType,
            @RequestParam(name = "year") Integer year
    ) {
        return ResponseEntity.ok(this.transactionService.reportByCategory(releaseType, year));
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
