package com.banking.transfer.api.adviser;

import com.banking.transfer.api.exception.AccountNotFound;
import com.banking.transfer.api.exception.InsufficientBalance;
import com.banking.transfer.api.utils.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<StandardResponse> handleAccountNotFoundException(AccountNotFound e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404 , e.getMessage(), null
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleGenericException(Exception e) {
        return new ResponseEntity<>(
                new StandardResponse(
                        500,
                        "An unexpected error occurred",
                        null
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(InsufficientBalance.class)
    public ResponseEntity<StandardResponse> handleInsufficientAccountBalanceException(Exception e) {
        return new ResponseEntity<>(
                new StandardResponse(
                        400,
                        e.getMessage(),
                        null
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
