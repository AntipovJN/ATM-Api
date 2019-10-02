package com.atm.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "bank")
    private String bank;
    @OneToOne
    private AmountInDenominations amountInDenominations;

    public ATM() {
    }

    public ATM(String address, String bank, AmountInDenominations amountInDenominations) {
        this.address = address;
        this.bank = bank;
        this.amountInDenominations = amountInDenominations;
    }

    public AmountInDenominations getAmountInDenominations() {
        return amountInDenominations;
    }

    public void setAmountInDenominations(AmountInDenominations amountInDenominations) {
        this.amountInDenominations = amountInDenominations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ATM atm = (ATM) o;

        if (getId() != null ? !getId().equals(atm.getId()) : atm.getId() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(atm.getAddress()) : atm.getAddress() != null)
            return false;
        if (getBank() != null ? !getBank().equals(atm.getBank()) : atm.getBank() != null)
            return false;
        return getAmountInDenominations() != null ? getAmountInDenominations().equals(atm.getAmountInDenominations()) : atm.getAmountInDenominations() == null;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", bank='" + bank + '\'' +
                ", amountInDenominations=" + amountInDenominations +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getBank() != null ? getBank().hashCode() : 0);
        result = 31 * result + (getAmountInDenominations() != null ? getAmountInDenominations().hashCode() : 0);
        return result;
    }
}
