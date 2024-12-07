import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] firstLine = br.readLine().trim().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int K = Integer.parseInt(firstLine[1]);
            String[] values = br.readLine().trim().split(" ");
            int[] A = new int[N];

            // Parse the values into the array A
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(values[i]);
            }

            // Dynamic Programming array
            long[] dp = new long[N];
            long maxPoints = Long.MIN_VALUE;

            // Fill dp array from the end to the start
            for (int i = N - 1; i >= 0; i--) {
                dp[i] = A[i];
                if (i + K < N) {
                    dp[i] += dp[i + K];
                }
                maxPoints = Math.max(maxPoints, dp[i]);
            }

            output.append(maxPoints).append("\n");
        }

        System.out.print(output);
    }
}
