package com.algaworks.algaposts.text_processor_service.infrastructure.rabbitmq;

import com.algaworks.algaposts.text_processor_service.domain.model.PostMessageInput;
import com.algaworks.algaposts.text_processor_service.domain.service.PostMessageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.algaworks.algaposts.text_processor_service.infrastructure.rabbitmq.RabbitMQQueueConstants.TEXT_PROCESSOR_QUEUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQListener {

    private final PostMessageService postMessageService;

    @SneakyThrows
    @RabbitListener(queues = TEXT_PROCESSOR_QUEUE, concurrency = "2-3")
    public void handlePostService(@Payload PostMessageInput data,
                       @Headers Map<String, Object> headers) {

        log.info("Received data: {}", data);
        log.info("Received headers: {}", headers);

        postMessageService.sendProcessedMessage(data);
    }
}
