import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // Edge case for arrays of size 1
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        // Step 1: Create prefix and suffix GCD arrays
        int[] prefixGCD = new int[n];
        int[] suffixGCD = new int[n];

        prefixGCD[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], arr[i]);
        }

        suffixGCD[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i + 1], arr[i]);
        }

        // Step 2: Calculate maximum GCD by removing one element
        int maxGCD = 0;
        for (int i = 0; i < n; i++) {
            int gcdWithoutCurrent;
            if (i == 0) {
                gcdWithoutCurrent = suffixGCD[1]; // No prefix
            } else if (i == n - 1) {
                gcdWithoutCurrent = prefixGCD[n - 2]; // No suffix
            } else {
                gcdWithoutCurrent = gcd(prefixGCD[i - 1], suffixGCD[i + 1]);
            }
            maxGCD = Math.max(maxGCD, gcdWithoutCurrent);
        }

        System.out.println(maxGCD);
    }

    // Helper method to calculate GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
