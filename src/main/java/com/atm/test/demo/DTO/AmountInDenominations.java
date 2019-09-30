package com.atm.test.demo.DTO;

public class AmountInDenominations {

    private Integer count100denomination;
    private Integer count200denomination;
    private Integer count500denomination;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AmountInDenominations that = (AmountInDenominations) o;

        if (getCount100denomination() != null ? !getCount100denomination().equals(that.getCount100denomination()) : that.getCount100denomination() != null)
            return false;
        if (getCount200denomination() != null ? !getCount200denomination().equals(that.getCount200denomination()) : that.getCount200denomination() != null)
            return false;
        return getCount500denomination() != null ? getCount500denomination().equals(that.getCount500denomination()) : that.getCount500denomination() == null;
    }

    @Override
    public int hashCode() {
        int result = getCount100denomination() != null ? getCount100denomination().hashCode() : 0;
        result = 31 * result + (getCount200denomination() != null ? getCount200denomination().hashCode() : 0);
        result = 31 * result + (getCount500denomination() != null ? getCount500denomination().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AmountInDenominations{" +
                "count100denomination=" + count100denomination +
                ", count200denomination=" + count200denomination +
                ", count500denomination=" + count500denomination +
                '}';
    }
}
