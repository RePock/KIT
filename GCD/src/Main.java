public class Main {

    public static void main(String[] args) {
        System.out.println(gcd(27,18));//9
        System.out.println(gcd(108,54));//54
        System.out.println(gcd(125,75));//25
    }
        public static long gcd(long a,long b) {
            while (b !=0) {
                long tmp = a%b;
                a = b;
                b = tmp;
            }
            return a;
        }
}
