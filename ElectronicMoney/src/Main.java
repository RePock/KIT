import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int P = 97, Q = 101; //simple numbers
        int c;
        long N, n, r, m, d, nn, mm, rr;
        boolean answer;

        N = P * Q;

        Random random = new Random();
        do {
            c = 1 + random.nextInt(100 - 1); // random 1 from 101
            d = findingDbyC(c, (P - 1) * (Q - 1));
        } while ((c * d) % ((P - 1) * (Q - 1)) != 1);

        n = 1 + random.nextInt(P * Q - 1); // random 1 from N-1

        do {
            r = 1 + random.nextInt(P * Q - 1);// random 1 from N-1
        } while (gcd(r, N) != 1);

        nn = modexp(modexp(n, 1, N) * modexp(r, d, N), 1, N);
        mm = modexp(nn, c, N);
        rr = inversion(r, N);
        m = modexp(mm * rr, 1, N);

        answer = (modexp(n,c,N) == m);
        System.out.println(answer);
    }

    public static long modexp(long x, long y, long N) {
        if (y == 0) return 1;
        long z = modexp(x, y / 2, N);
        if (y % 2 == 0)
            return (((z * z) % N) + N) % N;
        else
            return (((x * z * z) % N) + N) % N;
    }

    public static long findingDbyC(long c, long p) {
        long oldp = p;
        long d = 0;
        long newd = 1;
        long tmp;
        long newc;
        long tmpd;
        while (c != 0) {
            tmp = p / c;
            newc = p - c * tmp;
            p = c;
            c = newc;
            tmpd = d - newd * tmp;
            d = newd;
            newd = tmpd;
        }
        if (d < 0) {
            d += oldp;
        }
        return d;
    }

    public static int hashFunction(long x, long N) {
        double A = 0.618033;
        int h = (int) (N * (x * A % 1));
        return h;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static long inversion(long x, long m) {
        x = x % m;
        for (long i = 1; i < m; i++) {
            if ((x * i) % m == 1) {
                return i;
            }
        }
        return 0;
    }
}