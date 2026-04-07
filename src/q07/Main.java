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

        // Pair array (value + original index)
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(arr[i], i);
        }

        // Sort based on value
        Arrays.sort(p, (a, b) -> a.value - b.value);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            // already visited or already correct
            if (visited[i] || p[i].index == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = p[j].index;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(p[i].value);
            if (i < n - 1) System.out.print(" ");
        }

        System.out.println();
        System.out.print("Swaps: " + swaps);
    }
}
