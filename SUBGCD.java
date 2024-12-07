import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    // Helper method to compute GCD of two numbers
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        // Number of test cases
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0) {
            // Read the size of the array
            int N = Integer.parseInt(br.readLine().trim());
            
            // Read the array elements
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            
            // Calculate the GCD of the entire array
            int arrayGCD = arr[0];
            for (int i = 1; i < N; i++) {
                arrayGCD = gcd(arrayGCD, arr[i]);
                // If at any point GCD becomes 1, we can break early
                if (arrayGCD == 1) break;
            }
            
            // Determine the output for the current test case
            if (arrayGCD == 1) {
                output.append(N).append("\n");
            } else {
                output.append("-1\n");
            }
        }
        
        // Print all results at once
        System.out.print(output);
    }
}
