import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            solve(reader, output);
        }

        System.out.print(output);
    }

    public static void solve(BufferedReader reader, StringBuilder output) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());

        int[] vec = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            vec[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // Sort the array to prepare for binary search
        Arrays.sort(vec);
        
        // Precompute cumulative triplets
        long[] cumulativeTriplets = new long[n - 2];
        long currentTriplets = 0;
        for (int i = 0; i < n - 2; i++) {
            currentTriplets += ((long) (n - i - 2) * (n - i - 1)) / 2;
            cumulativeTriplets[i] = currentTriplets;
        }

        // Handle each query
        for (int i = 0; i < q; i++) {
            long k = Long.parseLong(reader.readLine());
            int index = Arrays.binarySearch(cumulativeTriplets, k);

            // If not found, `index` is the insertion point
            if (index < 0) {
                index = -index - 1; // Convert to insertion index
            }

            // Ensure index is within bounds
            if (index < n) {
                output.append(vec[index]).append("\n");
            } else {
                output.append("Out of bounds\n"); // Handle case if index exceeds bounds
            }
        }
    }
}
