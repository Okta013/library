package ru.anikeeva.test.library.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Транзакции", description = "Операции с транзакциями")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/change")
    @Operation(summary = "Осуществление транзакции",
            description = "Находит последнюю транзакцию для читателя и книги, " +
                    "создает новую транзакцию с противоположной операцией " +
                    "или с операцией TAKING, если ранее транзакций не было")
    public TransactionDTO makeTransaction(@RequestParam @Parameter(description = "ID читателя",
            example = "1323316b-8d7b-43b6-a94c-e4b0a32a13fe") UUID readerId,
            @RequestParam @Parameter(description = "ID книги",
                    example = "bffe786c-c507-4296-ba18-41a086eed8a9") UUID bookId)
    {
        return transactionService.makeTransaction(readerId, bookId);
    }
}
