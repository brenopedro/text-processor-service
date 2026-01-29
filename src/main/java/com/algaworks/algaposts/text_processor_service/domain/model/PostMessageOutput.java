package com.algaworks.algaposts.text_processor_service.domain.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostMessageOutput {

    private TSID postId;
    private Integer wordCount;
    private Double calculatedValue;
}
