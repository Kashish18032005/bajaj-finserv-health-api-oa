package com.chitkara.bfhl.exception;

import com.chitkara.bfhl.dto.BfhlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponse> handleException(Exception e) {
        BfhlResponse response = new BfhlResponse();
        response.setSuccess(false);
        response.setOddNumbers(Collections.emptyList());
        response.setEvenNumbers(Collections.emptyList());
        response.setAlphabets(Collections.emptyList());
        response.setSpecialCharacters(Collections.emptyList());
        response.setSum("0");
        response.setConcatString("");
        return ResponseEntity.status(400).body(response);
    }
}
