package com.alticci.labseq.controllers;


import com.alticci.labseq.dto.LabseqResponseDTO;
import com.alticci.labseq.service.LabseqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/labseq")
@Validated
public class LabSeqControllerImpl implements LabSeqController {
    @Autowired private LabseqService service;

    @Override
    @GetMapping("/{index}")
    public ResponseEntity<LabseqResponseDTO> findAlticciIndex(
            @PathVariable Long index) {

        long value = service.calculateLabSeq(index);

        return ResponseEntity.ok(LabseqResponseDTO.builder().index(index).value(value).build());
    }
}
