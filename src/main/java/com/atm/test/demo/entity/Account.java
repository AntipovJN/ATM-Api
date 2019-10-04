package com.atm.test.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "account_atm")
public class Account implements UserDetails {

    @Id
    private Long cardId;
    @Column(name = "pin")
    private String pin;
    @Column(name = "card_balance")
    private BigInteger balance;

    public Account() {
    }

    public Account(Long cardId, String pin) {
        this.cardId = cardId;
        this.pin = pin;
        this.balance = BigInteger.valueOf(0);
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Account user = (Account) o;

        if (getCardId() != null ? !getCardId().equals(user.getCardId()) : user.getCardId() != null)
            return false;
        if (getPin() != null ? !getPin().equals(user.getPin()) : user.getPin() != null)
            return false;
        return getBalance() != null ? getBalance().equals(user.getBalance()) : user.getBalance() == null;
    }

    @Override
    public int hashCode() {
        int result = (getCardId() != null ? getCardId().hashCode() : 0);
        result = 31 * result + (getPin() != null ? getPin().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", cardId=" + cardId +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return getPin();
    }

    @Override
    public String getUsername() {
        return getCardId().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
