package xyz.solidnetwork.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.account.transaction.Report;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private RestTemplate restTemplate;

    public Report getReport() {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:80"));

        log.info("microservice transaction-service is invoked");
        return restTemplate.postForObject("/private/transaction", "body-request", Report.class);

    }

}
