package com.banking.transfer.api.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountRequestDto {
    private long toAccountNumber;

    private String fromAccountHolderName;

    private String toAccountHolderName;

    private double transferAmount;

    private double accountBalance;
}
