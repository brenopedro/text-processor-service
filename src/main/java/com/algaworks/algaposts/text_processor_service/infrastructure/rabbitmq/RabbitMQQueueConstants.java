package com.algaworks.algaposts.text_processor_service.infrastructure.rabbitmq;

public class RabbitMQQueueConstants {

    public static final String EXCHANGE = "post-service.post-received.v1.e";
    public static final String TEXT_PROCESSOR_QUEUE = "text-processor-service.post-processing.v1.q";
    public static final String DEAD_LETTER_TEXT_PROCESSOR_QUEUE = "text-processor-service.post-processing.v1.dlq";
}
