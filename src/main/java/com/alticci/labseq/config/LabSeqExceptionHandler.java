package com.alticci.labseq.config;

import com.alticci.labseq.dto.ErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class LabSeqExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleConstraintViolation(
            ConstraintViolationException exception) {

        ErrorResponseDTO errorDTO =
                ErrorResponseDTO.builder().message(exception.getMessage().split(": ")[1]).build();

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<ErrorResponseDTO> handleStackOverflow(StackOverflowError exception) {

        ErrorResponseDTO errorDTO =
                ErrorResponseDTO.builder().message("Value not accepted, please enter a positive number or a smaller one!").build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException exception) {

        ErrorResponseDTO errorDTO =
                ErrorResponseDTO.builder()
                        .message("Maximum acceptable index is 9.223.372.036.854.775.807")
                        .build();

        return ResponseEntity.badRequest().body(errorDTO);
    }

}
