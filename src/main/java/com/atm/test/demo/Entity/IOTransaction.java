package com.atm.test.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "IO_transaction")
public class IOTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private ATM atm;
    @OneToOne
    private User recipient;
    @Column(name = "sum")
    private BigInteger sum;

    public IOTransaction() {
    }

    public IOTransaction( ATM atm, User recipient, BigInteger sum) {
        this.atm = atm;
        this.recipient = recipient;
        this.sum = sum;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        IOTransaction that = (IOTransaction) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getAtm() != null ? !getAtm().equals(that.getAtm()) : that.getAtm() != null)
            return false;
        if (getRecipient() != null ? !getRecipient().equals(that.getRecipient()) : that.getRecipient() != null)
            return false;
        return getSum() != null ? getSum().equals(that.getSum()) : that.getSum() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAtm() != null ? getAtm().hashCode() : 0);
        result = 31 * result + (getRecipient() != null ? getRecipient().hashCode() : 0);
        result = 31 * result + (getSum() != null ? getSum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IOTransaction{" +
                "id=" + id +
                ", atm=" + atm +
                ", recipient=" + recipient +
                ", sum=" + sum +
                '}';
    }
}
