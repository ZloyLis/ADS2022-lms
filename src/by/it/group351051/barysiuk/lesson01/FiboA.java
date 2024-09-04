package by.it.group351051.barysiuk.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить рекурсивный способ вычисления чисел Фибоначчи
 */

public class FiboA {

    private final long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboA fibo = new FiboA();
        final int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        // вычисление чисел Фибоначчи медленным методом (рекурсией)
        fibo = new FiboA();
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());
    }

    private int calc(int n) {
        /*
         * здесь простейший вариант, в котором код совпадает с математическим определением чисел Фибоначчи
         * время O(2^n)
         */
        if (n < 2) return n;
        return (calc(n - 1) + calc(n - 2));
    }

    BigInteger slowA(Integer n) {

        /*
         * Рекурсия
         * Здесь нужно реализовать вариант без ограничения на размер числа,
         * в котором код совпадает с математическим определением чисел Фибоначчи
         * Время: O(2^n)
         */

        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        return slowA(n - 1).add(slowA(n - 2));
    }
}