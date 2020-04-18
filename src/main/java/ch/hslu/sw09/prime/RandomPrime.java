package ch.hslu.sw09.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class RandomPrime implements Callable<BigInteger> {
    @Override
    public BigInteger call() throws Exception {
        BigInteger bi = new BigInteger(1024, new Random());
        while (!bi.isProbablePrime(Integer.MAX_VALUE)) {
            bi = new BigInteger(1024, new Random());
        }
        return bi;
    }
}
