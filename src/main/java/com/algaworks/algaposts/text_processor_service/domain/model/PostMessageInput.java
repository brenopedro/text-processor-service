package com.algaworks.algaposts.text_processor_service.domain.model;

import io.hypersistence.tsid.TSID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMessageInput {

    private TSID postId;
    private String postBody;
}
