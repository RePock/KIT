import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(babyStepGiantStep(2, 61, 45));//34
        System.out.println(babyStepGiantStep(2, 30203, 24322));//10000
        System.out.println(babyStepGiantStep(2, 30323, 21740));//20000
        System.out.println(babyStepGiantStep(2, 30539, 28620));//1000
        System.out.println(babyStepGiantStep(2, 30803, 16190));//12345
        System.out.println(babyStepGiantStep(5, 31607, 30994));//25000
    }

    public static long babyStepGiantStep(int a, int p, int y) {
        long x;
        long n, m;
        long k = 0, l = 0;

        n = m = (long) Math.sqrt(p) + 1;

        ArrayList<Long> list1 = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            long z = modexp(modexp(a, i, p) * modexp(y, 1, p), 1, p);
            list1.add(z);
        }

        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            long z = modexp(a, i * n, p);
            list2.add(z);
            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(j) == z) {
                    k = j;
                    l = i;
                    break;
                }
            }
        }

        x = n * l - k;

        return x;
    }

    public static long modexp(long x, long y, long N) {
        if (y == 0) return 1;
        long z = modexp(x, y / 2, N);
        if (y % 2 == 0)
            return (((z * z) % N) + N) % N;
        else
            return (((x * z * z) % N) + N) % N;
    }

}