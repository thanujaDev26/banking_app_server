package com.banking.transfer.api.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountResponseDto {
    private long toAccountNumber;

    private String fromAccountHolderName;

    private String toAccountHolderName;

    private double transferAmount;

    private double accountBalance;
}
