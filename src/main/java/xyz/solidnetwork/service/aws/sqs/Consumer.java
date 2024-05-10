package xyz.solidnetwork.service.aws.sqs;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.Const;
import xyz.solidnetwork.service.transaction.TransactionService;

@Service
@Slf4j
public class Consumer {

    @Autowired
    private TransactionService transactionService;

    @SqsListener(value = "${aws.transaction.request.queue.name}")
    public void listen(Message<Request> message, @Headers Map<String, String> headers) {

        try {

            final String userId = getHeader(Const.USER_ID, headers);
            final String traceId = getHeader(Const.TRACE_ID, headers);

            MDC.put(Const.USER_ID, userId);
            MDC.put(Const.TRACE_ID, traceId);

            log.info("messageFromQueue={} headers={}", message, headers);

            transactionService.sendReport(message.getPayload());
        } finally {
            MDC.clear();

        }

    }

    private String getHeader(String headerName, Map<String, String> headers) {

        return headers.get(headerName);

    }

}