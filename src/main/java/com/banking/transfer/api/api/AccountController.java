package com.banking.transfer.api.api;


import com.banking.transfer.api.service.AccountService;
import com.banking.transfer.api.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfer")
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> transferFunds(@RequestParam long fromAccountNumber, @RequestParam long toAccountNumber, @RequestParam double amount){
        return new  ResponseEntity<>(
            new StandardResponse(
                201 , "Funds transferred successfully" , this.service.transfer(fromAccountNumber, toAccountNumber,amount)
            ),HttpStatus.OK
        );
    }

    @GetMapping("/{number}")
    public ResponseEntity<StandardResponse> getAccountDetails(@PathVariable long number){
        return new ResponseEntity<>(
                new StandardResponse(200, "Account Details are fetched", this.service.checkBalance(number)),HttpStatus.OK
        );
    }
}
