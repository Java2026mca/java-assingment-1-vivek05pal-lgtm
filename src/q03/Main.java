import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int val = 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) a[top][i] = val++;
            top++;

            for (int i = top; i <= bottom; i++) a[i][right] = val++;
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) a[bottom][i] = val++;
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) a[i][left] = val++;
                left++;
            }
        }

        int diag = 0;
        for (int i = 0; i < n; i++) {
            diag += a[i][i];
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + (j < n - 1 ? " " : ""));
            }
            System.out.println();
        }

        System.out.println("Diagonal: " + diag);
    }
}
