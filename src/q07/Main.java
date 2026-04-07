import java.util.*;

public class Main {
    static class Pair {
        int value, index;

        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Create pair array
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Sort by value
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Find cycles
        for (int i = 0; i < n; i++) {

            // already visited or already in correct position
            if (visited[i] || pairs[i].index == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].index;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(pairs[i].value);
            if (i < n - 1) System.out.print(" ");
        }

        System.out.println();
        System.out.println("Swaps: " + swaps);
    }
}
          
     
