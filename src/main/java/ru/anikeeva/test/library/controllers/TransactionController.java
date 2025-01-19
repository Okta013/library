package ru.anikeeva.test.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anikeeva.test.library.dto.TransactionDTO;
import ru.anikeeva.test.library.services.TransactionService;

import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/change")
    public TransactionDTO makeTransaction(@RequestParam UUID readerId, @RequestParam UUID bookId) {
        return transactionService.makeTransaction(readerId, bookId);
    }
}
