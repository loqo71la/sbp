package dev.loqo71la.bp.model;

import dev.loqo71la.bp.common.contant.ModelConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = ModelConstant.TRANSACTION)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = ModelConstant.DATE)
    private Date date;

    @Column(name = ModelConstant.TRANSACTION_TYPE)
    private TransactionType type;

    @Column(name = ModelConstant.VALUE)
    private double value;

    @Column(name = ModelConstant.BALANCE)
    private double balance;

    @ManyToOne
    @JoinColumn(name = ModelConstant.ACCOUNT_ID, nullable = false)
    private Account account;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
