package by.it.group351051.barysiuk.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * Время расчета должно быть НЕ БОЛЕЕ 2 секунд
 */

public class FiboC {

    private final long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        /*
         * Решение сложно найти интуитивно
         * возможно потребуется дополнительный поиск информации
         * смотри период Пизано
         */
        long pisanoPeriod = pisanoPeriod(m);
        long reducedN = n % pisanoPeriod;

        return fibModul(reducedN, m);
    }

    private long pisanoPeriod(int m) {
        long previous = 0, current = 1;

        for (long i = 0; i < (long) m * m; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;

            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }

        return -1;
    }

    private long fibModul(long n, int m) {
        long previous = 0, current = 1;

        if (n == 0) return previous;
        if (n == 1) return current;

        for (long i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }
        return current;
    }
}
