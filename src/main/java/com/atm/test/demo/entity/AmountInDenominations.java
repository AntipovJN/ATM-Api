package com.atm.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmountInDenominations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "denom100")
    private Integer count100denomination;
    @Column(name = "denom200")
    private Integer count200denomination;
    @Column(name = "denom500")
    private Integer count500denomination;

    public AmountInDenominations() {
    }

    public AmountInDenominations(Integer count100denomination, Integer count200denomination, Integer count500denomination) {
        this.count100denomination = count100denomination;
        this.count200denomination = count200denomination;
        this.count500denomination = count500denomination;
    }


    public Integer getCount100denomination() {
        return count100denomination;
    }

    public void setCount100denomination(Integer count100denomination) {
        this.count100denomination = count100denomination;
    }

    public Integer getCount200denomination() {
        return count200denomination;
    }

    public void setCount200denomination(Integer count200denomination) {
        this.count200denomination = count200denomination;
    }

    public Integer getCount500denomination() {
        return count500denomination;
    }

    public void setCount500denomination(Integer count500denomination) {
        this.count500denomination = count500denomination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AmountInDenominations that = (AmountInDenominations) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getCount100denomination() != null ? !getCount100denomination().equals(that.getCount100denomination()) : that.getCount100denomination() != null)
            return false;
        if (getCount200denomination() != null ? !getCount200denomination().equals(that.getCount200denomination()) : that.getCount200denomination() != null)
            return false;
        return getCount500denomination() != null ? getCount500denomination().equals(that.getCount500denomination()) : that.getCount500denomination() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCount100denomination() != null ? getCount100denomination().hashCode() : 0);
        result = 31 * result + (getCount200denomination() != null ? getCount200denomination().hashCode() : 0);
        result = 31 * result + (getCount500denomination() != null ? getCount500denomination().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AmountInDenominations{" +
                "id=" + id +
                ", count100denomination=" + count100denomination +
                ", count200denomination=" + count200denomination +
                ", count500denomination=" + count500denomination +
                '}';
    }
}
