import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long p = 30803;
        long g = 2;
        long Ya, Yb, Zab, Zba;
        int Xa, Xb;

        Random random = new Random();
        Xa = 1 + random.nextInt(100 - 1); // random 1 from 101
        Ya = modexp(g, Xa, p);

        Xb =  1 + random.nextInt(100 - 1); // random 1 from 101
        Yb = modexp(g, Xb, p);

        Zab = modexp(Yb, Xa, p);
        Zba = modexp(Ya, Xb, p);

        System.out.println(Zab);
        System.out.println(Zba); // Zab == Zba

    }

    public static long modexp(long x, long y, long N) {
        if (y == 0) return 1;
        long z = modexp(x, y / 2, N);
        if (y % 2 == 0)
            return (z * z) % N;
        else
            return (x * z * z) % N;
    }
}
