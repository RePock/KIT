public class Main {

    public static void main(String[] args) {
        System.out.println(inversion(3,26));//9
        System.out.println(inversion(25,67));//59
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
