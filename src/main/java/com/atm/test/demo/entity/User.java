package com.atm.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user_atm")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @OneToMany
    private List<Account> bankAccounts;

    public User(String fullName, List<Account> bankAccounts) {
        this.fullName = fullName;
        this.bankAccounts = bankAccounts;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
