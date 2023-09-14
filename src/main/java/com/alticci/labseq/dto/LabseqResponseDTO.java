package com.alticci.labseq.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabseqResponseDTO {
    private long index;
    private long value;
}