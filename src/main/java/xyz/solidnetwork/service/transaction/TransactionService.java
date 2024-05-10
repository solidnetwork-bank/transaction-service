package xyz.solidnetwork.service.transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.aws.sqs.Producer;
import xyz.solidnetwork.service.aws.sqs.Request;
import xyz.solidnetwork.service.aws.sqs.Response;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private Producer producer;

    public TransactionService() {
        super();
    }

    private Report getreport() {
        Report report = new Report();
        report.setAccount("5544 3322 1100");
        report.setDeposits(getDeposits());
        report.setFees(getFees());
        report.setWithdrawals(getWithdrawals());
        return report;
    }

    private List<Transaction> getDeposits() {
        List<Transaction> deposits = new ArrayList<>();
        deposits.add(getTransaction("11", LocalDate.of(2024, 03, 15),
                "Direct Deposit transfer from CHK 7788 Confirmation # 557788445", 4511.03));

        deposits.add(getTransaction("22", LocalDate.of(2024, 03, 18),
                "Direct Deposit transfer from CHK 7788 Confirmation # 114455754", 630.00));

        deposits.add(getTransaction("33", LocalDate.of(2024, 03, 30),
                "Direct Deposit transfer from CHK 7788 Confirmation # 114455754", 3804.95));

        return deposits;
    }

    private List<Transaction> getWithdrawals() {
        List<Transaction> withdrawals = new ArrayList<>();
        withdrawals.add(getTransaction("44", LocalDate.of(2024, 03, 05),
                "Online Banking transfer to CHK 3322 Confirmation # 5544778899", -25.00));

        return withdrawals;
    }

    private List<Transaction> getFees() {
        List<Transaction> fees = new ArrayList<>();
        fees.add(getTransaction("55", LocalDate.of(2024, 03, 23), "Monthly Maintenance Fee", -5.00));

        return fees;
    }

    public void sendReport(Request request) {
        log.info("microservice account-service answered through fifo queue");

        Response response = new Response();
        response.setReport(getreport());
        producer.send(response);
    }

    private Transaction getTransaction(String id, LocalDate date, String desc, Double amount) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAmount(amount);
        transaction.setDate(date);
        transaction.setDesc(desc);
        return transaction;
    }

}
