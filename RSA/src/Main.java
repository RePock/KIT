import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int Pa = 131, Qa = 227, Pb = 113, Qb = 281, Ca = 3, Cb = 3, Na, Nb;
        long x, Da, Db, y, w;
        boolean answer;

        Na = Pa * Qa;
        Nb = Pb * Qb;

        Da = findingDbyC(Ca, (Pa - 1) * (Qa - 1));
        Db = findingDbyC(Cb, (Pb - 1) * (Qb - 1));

        Random random = new Random();
        x = 1 + random.nextInt(Nb);// random 1 from p-1

        y = modexp(x, Db, Nb);
        w = modexp(y, Cb, Nb);

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