import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int p = 30803;
        long x, Da, Db, y, z, u, w;
        int Ca, Cb;
        boolean answer;

        Random random = new Random();
        do {
            x = 1 + random.nextInt(p - 2);// random 1 from p-1
            Ca = 1 + random.nextInt(100 - 1); // random 1 from 101
            Cb = 1 + random.nextInt(100 - 1); // random 1 from 101

            Da = findingDbyC(Ca, p - 1);
            Db = findingDbyC(Cb, p - 1);
        }while ((((Ca * Da) % (p - 1)) != 1)||(((Cb * Db) % (p - 1)) != 1));

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
}
