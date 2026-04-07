import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] mat = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        // Fill spiral
        while (top <= bottom && left <= right) {

            // left → right
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++;
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++;
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    mat[bottom][i] = num++;
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = num++;
                }
                left++;
            }
        }

        // Build output
        StringBuilder sb = new StringBuilder();
        int diagSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
            diagSum += mat[i][i]; // main diagonal
        }

        sb.append("Diagonal: ").append(diagSum);

        System.out.print(sb.toString());
    }
}
