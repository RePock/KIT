public class Main {
    public static void main(String[] args) {
        System.out.println(modexp(7,57,100));//7
        System.out.println(modexp(2,8,10));//6
        System.out.println(modexp(5,23,47));//46
    }
    public static long modexp(long x, long y, long N)
    {
        if (y == 0) return 1;
        long z = modexp(x, y / 2, N);
        if (y % 2 == 0)
            return (z*z) % N;
        else
            return (x*z*z) % N;
    }
}
