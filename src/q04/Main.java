import java.util.*;

public class Main {

    // Check Prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Check Perfect
    static boolean isPerfect(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 is always a divisor
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            if (isPerfect(n)) {
                System.out.println("Perfect");
            } else if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Neither");
            }
        }
    }
}
