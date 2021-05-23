package com.thefoodworld.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "account_password")
    private String accountPassword;

    @Column(name = "account_email")
    private String accountEmail;

    @Column(name = "account_status")
    private Integer accountStatus;

    @Column(name = "account_register_time")
    private Timestamp accountRegisterTime;

    @Column(name = "account_login_time")
    private Timestamp accountLoginTime;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Timestamp getAccountRegisterTime() {
        return accountRegisterTime;
    }

    public void setAccountRegisterTime(Timestamp accountRegisterTime) {
        this.accountRegisterTime = accountRegisterTime;
    }

    public Timestamp getAccountLoginTime() {
        return accountLoginTime;
    }

    public void setAccountLoginTime(Timestamp accountLoginTime) {
        this.accountLoginTime = accountLoginTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
