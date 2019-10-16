import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //0 step
        int p = 3209;
        long Da, Db, Ua, w, z, deck;
        int Ca, Cb, tmp;
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> u = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();

        Random random = new Random();
        do {
            Ca = 1 + random.nextInt(100 - 1); // random 1 from 100
            Cb = 1 + random.nextInt(100 - 1); // random 1 from 100

            Da = findingDbyC(Ca, p - 1);
            Db = findingDbyC(Cb, p - 1);
        } while ((((Ca * Da) % (p - 1)) != 1) || (((Cb * Db) % (p - 1)) != 1));

        //1 step
        for (int i = 0; i < 3; i++) {
            r.add(1 + random.nextInt(p - 1));
        }

        for (int i = 0; i < 3; i++) {
            u.add((int) modexp(r.get(i), Ca, p));
        }
        Collections.shuffle(u);

        //2 step
        tmp = random.nextInt(3);
        Ua = modexp(u.get(tmp), Da, p);//Alice card
        u.remove(tmp);

        //3 step
        for (int i = 0; i < 2; i++) {
            v.add((int) modexp(u.get(i), Cb, p));
        }
        Collections.shuffle(v);

        //4 step
        tmp = random.nextInt(2);
        w = modexp(v.get(tmp), Da, p);
        z = modexp(w, Db, p);//Bob card

        //5 step
        v.remove(tmp);
        deck = modexp(modexp(v.get(0), Da, p), Db, p);//card in deck
        System.out.println(r.get(0) + " " + r.get(1) + " " + r.get(2));//starter cards
        System.out.println(Ua + " " + z + " " + deck);//cards after distribution
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

}