package dev.loqo71la.bp.model;

import dev.loqo71la.bp.common.contant.ModelConstant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = ModelConstant.CLIENT)
public class Client extends Person {

    @Column(name = ModelConstant.CLIENT_ID)
    private String clientId;

    @Column(name = ModelConstant.PASSWORD)
    private String password;

    @Column(name = ModelConstant.STATUS)
    private boolean status;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Account> accountList;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
