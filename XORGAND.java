import java.util.*;
import java.io.*;
class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim()); // Size of the array
            int[] A = new int[N];
            String[] arrayInput = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(arrayInput[i]);
            }
            int Q = Integer.parseInt(br.readLine().trim()); // Number of queries
            // For storing the highest set bit count precomputed
            int[][] prefix = new int[N + 1][33];
            for (int i = 0; i < N; i++) {
                int bit = highestSetBit(A[i]);
                if (i > 0) {
                    for (int j = 0; j <= 32; j++) {
                        prefix[i + 1][j] = prefix[i][j];
                    }
                }
                prefix[i + 1][bit]++;
            }
            for (int q = 0; q < Q; q++) {
                String[] queryInput = br.readLine().trim().split(" ");
                int L = Integer.parseInt(queryInput[0]);
                int R = Integer.parseInt(queryInput[1]);
                int X = Integer.parseInt(queryInput[2]);
                int maxSetBitX = highestSetBit(X);
                int count = query(prefix, L, R, maxSetBitX);
                pw.println(R - L + 1 - count);
            }
        }
        pw.close();
    }
    private static int highestSetBit(int number) {
        for (int i = 31; i >= 0; i--) {
            if ((number & (1 << i)) != 0) {
                return i;
            }
        }
        return 32; // If number is zero
    }
    private static int query(int[][] prefix, int L, int R, int bit) {
        return prefix[R][bit] - prefix[L - 1][bit];
    }

}
