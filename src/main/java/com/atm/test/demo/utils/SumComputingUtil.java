package com.atm.test.demo.utils;

        import com.atm.test.demo.entity.AmountInDenominations;

        import java.math.BigInteger;

public class SumComputingUtil {

    public static BigInteger computeSum(int denom100, int denom200, int denom500) {
        return BigInteger.valueOf(denom100 * 100 + denom200 * 200 + denom500 * 500);
    }

    public static BigInteger computeSum(AmountInDenominations amountInDenominations) {
        return BigInteger.valueOf(amountInDenominations.getCount100denomination() * 100
                + amountInDenominations.getCount200denomination() * 200
                + amountInDenominations.getCount500denomination()* 500);
    }
}
