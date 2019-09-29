public class Main {

    public static void main(String[] args) {
        System.out.println(findingDbyC(7, 11));//3
        System.out.println(findingDbyC(5, 13));//5

    }

    public static long findingDbyC(long c, long p) {
        long d = 1;
        while (((c * d) % (p - 1)) != 1) {
            d++;
        }
        return d;
    }
}
