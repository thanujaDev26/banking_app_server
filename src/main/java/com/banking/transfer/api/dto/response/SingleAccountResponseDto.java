package com.banking.transfer.api.dto.response;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SingleAccountResponseDto {
    @Id
    private long accountNumber;

    private String accountHolderName;

    private double accountBalance;
}
