package com.atm.test.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "atm_transfer_transaction")
public class TransferTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private ATM atm;
    @OneToOne()
    private User sender;
    @OneToOne()
    private User recipient;
    @Column(name = "sum")
    private BigInteger sum;

    public TransferTransaction() {
    }

    public TransferTransaction(ATM atm, User sender, User recipient, BigInteger sum) {
        this.atm = atm;
        this.sender = sender;
        this.recipient = recipient;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TransferTransaction that = (TransferTransaction) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getAtm() != null ? !getAtm().equals(that.getAtm()) : that.getAtm() != null)
            return false;
        if (getSender() != null ? !getSender().equals(that.getSender()) : that.getSender() != null)
            return false;
        if (getRecipient() != null ? !getRecipient().equals(that.getRecipient()) : that.getRecipient() != null)
            return false;
        return getSum() != null ? getSum().equals(that.getSum()) : that.getSum() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAtm() != null ? getAtm().hashCode() : 0);
        result = 31 * result + (getSender() != null ? getSender().hashCode() : 0);
        result = 31 * result + (getRecipient() != null ? getRecipient().hashCode() : 0);
        result = 31 * result + (getSum() != null ? getSum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransferTransaction{" +
                "id=" + id +
                ", atm=" + atm +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", sum=" + sum +
                '}';
    }
}
