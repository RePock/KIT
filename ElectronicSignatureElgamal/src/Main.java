import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int P = 31259, g = 2;
        int h;
        long x, m, k, r, y, u, s, w, z;
        boolean answer;

        Random random = new Random();
        x = 1 + random.nextInt(P - 1);// random 1 from P-1
        y = modexp(g, x, P);

        m = 1 + random.nextInt(P);// random 1 from P
        h = hashFunction(m, P);

        do {
            k = 1 + random.nextInt(P - 1);// random 1 from P-1
        } while (gcd(k, P - 1) != 1);
        r = modexp(g, k, P);

        u = modexp((h - x * r), 1, P - 1);
        s = modexp(inversion(k, P - 1) * u, 1, P - 1);

        z = modexp(modexp(y, r, P) * modexp(r, s, P), 1, P);
        w = modexp(g, h, P);

        answer = (z == w);
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