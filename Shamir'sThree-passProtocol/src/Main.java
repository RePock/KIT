import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int p = 30803;
        long x, Da, Db, y, z, u, w;
        int Ca, Cb;
        boolean answer;

        Random random = new Random();
        x = 1 + random.nextInt(p - 2);// random 1 from p-1
        Ca = 1 + random.nextInt(100 - 1); // random 1 from 101
        Cb = 1 + random.nextInt(100 - 1); // random 1 from 101

        Da = findingDbyC(Ca,p);
        Db = findingDbyC(Cb,p);

        y = modexp(x,Ca,p);
        z = modexp(y,Cb,p);
        u = modexp(z,Da,p);
        w = modexp(u,Db,p);

        answer = (x==w);
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
        long d = 1;
        while (((c * d) % (p - 1)) != 1) {
            d++;
        }
        return d;
    }
}
