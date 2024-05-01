package xyz.solidnetwork.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/private/transaction")
    public Report getTransaction() {
        log.info("PRIVATE transaction is requested");
        return transactionService.getreport();
    }
}
