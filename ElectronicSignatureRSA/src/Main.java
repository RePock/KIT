import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int P = 97, Q = 101; //simple numbers
        int C, h;
        long N, x, D, y, w;
        boolean answer;

        N = P * Q;

        Random random = new Random();
        do {
            C = 1 + random.nextInt(100 - 1); // random 1 from 101
            D = findingDbyC(C, (P - 1) * (Q - 1));
        } while ((C * D) % ((P - 1) * (Q - 1)) != 1);

        x = 1 + random.nextInt(P * Q - 1);// random 1 from 1000

        h = hashFunction(x,N);

        y = modexp(h, C, N);
        w = modexp(y, D, N);

        answer = (h == w);
        System.out.println(answer);
    }

    public static long modexp(long x, long y, long N) {
        if (y == 0) return 1;
        long z = modexp(x, y / 2, N);
        if (y % 2 == 0)
            return (z * z) % N;
        else
            return (x * z * z) % N;
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

    public static int hashFunction(long x,long N) {
        double A = 0.618033;
        int h = (int) (N * (x * A % 1));
        return h;
    }
}