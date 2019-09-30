package com.atm.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "bank")
    private String bank;
    private Integer count100denomination;
    private Integer count200denomination;
    private Integer count500denomination;

    public ATM( String address, String bank, int count100denomination, int count200denomination, int count500denomination) {
        this.address = address;
        this.bank = bank;
        this.count100denomination = count100denomination;
        this.count200denomination = count200denomination;
        this.count500denomination = count500denomination;
    }

    public ATM() {
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

    public int getCount100denomination() {
        return count100denomination;
    }

    public void setCount100denomination(int count100denomination) {
        this.count100denomination = count100denomination;
    }

    public int getCount200denomination() {
        return count200denomination;
    }

    public void setCount200denomination(int count200denomination) {
        this.count200denomination = count200denomination;
    }

    public int getCount500denomination() {
        return count500denomination;
    }

    public void setCount500denomination(int count500denomination) {
        this.count500denomination = count500denomination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ATM atm = (ATM) o;

        if (getCount100denomination() != atm.getCount100denomination())
            return false;
        if (getCount200denomination() != atm.getCount200denomination())
            return false;
        if (getCount500denomination() != atm.getCount500denomination())
            return false;
        if (getId() != null ? !getId().equals(atm.getId()) : atm.getId() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(atm.getAddress()) : atm.getAddress() != null)
            return false;
        return getBank() != null ? getBank().equals(atm.getBank()) : atm.getBank() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getBank() != null ? getBank().hashCode() : 0);
        result = 31 * result + getCount100denomination();
        result = 31 * result + getCount200denomination();
        result = 31 * result + getCount500denomination();
        return result;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", bank='" + bank + '\'' +
                ", count100denomination=" + count100denomination +
                ", count200denomination=" + count200denomination +
                ", count500denomination=" + count500denomination +
                '}';
    }
}
