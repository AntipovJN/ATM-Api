package com.atm.test.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_atm")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    @Column(name = "pin")
    private String pin;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "card_balance")
    private BigInteger balance;

    public User() {
    }

    public User(Long cardId, String pin, String fullName) {
        this.cardId = cardId;
        this.pin = pin;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

        User user = (User) o;

        if (getCardId() != null ? !getCardId().equals(user.getCardId()) : user.getCardId() != null)
            return false;
        if (getPin() != null ? !getPin().equals(user.getPin()) : user.getPin() != null)
            return false;
        if (getFullName() != null ? !getFullName().equals(user.getFullName()) : user.getFullName() != null)
            return false;
        return getBalance() != null ? getBalance().equals(user.getBalance()) : user.getBalance() == null;
    }

    @Override
    public int hashCode() {
        int result = (getCardId() != null ? getCardId().hashCode() : 0);
        result = 31 * result + (getPin() != null ? getPin().hashCode() : 0);
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", cardId=" + cardId +
                ", pin=" + pin +
                ", fullName='" + fullName + '\'' +
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
        return getPin().toString();
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
