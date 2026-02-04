package com.algaworks.algaposts.text_processor_service.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PostMessageOutput {

    private UUID postId;
    private Integer wordCount;
    private Double calculatedValue;
}
