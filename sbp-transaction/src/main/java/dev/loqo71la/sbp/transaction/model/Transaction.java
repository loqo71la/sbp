package dev.loqo71la.sbp.transaction.model;

import dev.loqo71la.sbp.base.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Transaction extends Model {

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotBlank
    private String accountNumber;

    @NotNull
    private TransactionType type;

    @Column(precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(precision = 12, scale = 2)
    private BigDecimal balance;

    private String details;
}
