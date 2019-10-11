import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int p = 19;//30803;
        int g = 2;
        long x, Da, Db, k, y, w;
        int Ca, Cb, r;
        boolean answer;

        Random random = new Random();

        x = 4;//1 + random.nextInt(p - 2);// random 1 from p-1
        Ca = 7;//1 + random.nextInt(100 - 1); // random 1 from 101
        Cb = 3;//1 + random.nextInt(100 - 1); // random 1 from 101

        Da = modexp(g, Ca, p);
        Db = modexp(g, Cb, p);

        r = 5;//1 + random.nextInt(100 - 1); // random 1 from 101

        k = modexp(g, r, p);
        y = modexp(modexp(x, 1, p) * modexp(Db, r, p), 1, p);
        w = modexp(modexp(y, 1, p) * modexp(k, -Cb + p - 1, p), 1, p);

        answer = (x == w);
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

}