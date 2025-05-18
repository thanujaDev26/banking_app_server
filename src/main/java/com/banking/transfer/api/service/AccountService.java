package com.banking.transfer.api.service;

import com.banking.transfer.api.dto.response.AccountResponseDto;
import com.banking.transfer.api.dto.response.SingleAccountResponseDto;

public interface AccountService {

    public AccountResponseDto transfer(long fromAccount, long toAccount, double amount);

    public SingleAccountResponseDto checkBalance(long accountNUmber);

}
