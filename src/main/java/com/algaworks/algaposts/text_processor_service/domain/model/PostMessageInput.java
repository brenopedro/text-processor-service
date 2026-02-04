package com.algaworks.algaposts.text_processor_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMessageInput {

    private UUID postId;
    private String postBody;
}
