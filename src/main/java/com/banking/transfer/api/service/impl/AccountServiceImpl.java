package com.banking.transfer.api.service.impl;

import com.banking.transfer.api.dto.response.AccountResponseDto;
import com.banking.transfer.api.dto.response.SingleAccountResponseDto;
import com.banking.transfer.api.entity.Account;
import com.banking.transfer.api.repo.AccountRepo;
import com.banking.transfer.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo repo;

    @Autowired
    public AccountServiceImpl(AccountRepo repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public AccountResponseDto transfer(long fromAccount, long toAccount, double amount){
        Account from = this.repo.findById(fromAccount).orElseThrow(()->new RuntimeException("This Account Not Found"));
        Account to = this.repo.findById(toAccount).orElseThrow(()->new RuntimeException("This Account Not Found"));

        if(from.getAccountBalance() < amount){
            throw new RuntimeException("Insufficient Account Balance");
        }
       else {
            from.setAccountBalance(from.getAccountBalance()-amount);
            to.setAccountBalance(to.getAccountBalance()+amount);

            this.repo.save(from);
            this.repo.save(to);

            AccountResponseDto dto = new AccountResponseDto();
            dto.setToAccountNumber(fromAccount);
            dto.setFromAccountHolderName(from.getAccountHolderName());
            dto.setToAccountHolderName(to.getAccountHolderName());
            dto.setTransferAmount(amount);
            dto.setAccountBalance(from.getAccountBalance());

            return dto;
        }

    }

    @Override
    @Transactional
    public SingleAccountResponseDto checkBalance(long accountNumber){
        Account account = this.repo.findById(accountNumber).orElseThrow(()->new RuntimeException("Couldn't Find the Account, Check the Account number again!"));

        SingleAccountResponseDto dto = new SingleAccountResponseDto();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountHolderName(account.getAccountHolderName());
        dto.setAccountBalance(account.getAccountBalance());

        return dto;
    }
}
