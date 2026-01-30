package com.algaworks.algaposts.text_processor_service.domain.service;

import com.algaworks.algaposts.text_processor_service.domain.model.PostMessageInput;
import com.algaworks.algaposts.text_processor_service.domain.model.PostMessageOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.algaworks.algaposts.text_processor_service.infrastructure.rabbitmq.RabbitMQQueueConstants.EXCHANGE;
import static com.algaworks.algaposts.text_processor_service.infrastructure.rabbitmq.RabbitMQQueueConstants.ROUTING_KEY_PROCESSING;

@Service
@RequiredArgsConstructor
public class PostMessageService {

    private final RabbitTemplate rabbitTemplate;

    public void sendProcessedMessage(PostMessageInput data) {
        if (data == null || data.getPostId() == null || data.getPostBody() == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (data.getPostBody().trim().isEmpty()) {
            throw new IllegalArgumentException("Post body cannot be or empty");
        }
        int length = data.getPostBody().trim().split("\\s+").length;
        Double calculatedValue = length * 0.1;
        PostMessageOutput output = PostMessageOutput.builder()
                .postId(data.getPostId())
                .wordCount(length)
                .calculatedValue(calculatedValue)
                .build();

        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PROCESSING, output);
    }
}
