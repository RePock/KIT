public class Main {

    public static void main(String[] args) {
        System.out.println(findingDbyC(10, 54));//11
        System.out.println(findingDbyC(50, 162));//13
        System.out.println(findingDbyC(7, 11-1));//3
        System.out.println(findingDbyC(5, 13-1));//5
        System.out.println(findingDbyC(7, 13-1));//7

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
