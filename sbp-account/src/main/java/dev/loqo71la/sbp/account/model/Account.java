package dev.loqo71la.sbp.account.model;

import dev.loqo71la.sbp.base.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Account extends Model {

    @NotEmpty(message = "Account Number is required")
    @Column(nullable = false, unique = true)
    private String accountNumber;

    private AccountType type;

    private double initialBalance;

    private boolean status;

    @Positive(message = "Client ID is required")
    private long clientId;
}
