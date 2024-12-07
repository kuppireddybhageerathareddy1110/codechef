import java.io.*;
import java.util.*;

class ZEBRA {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        // Read the number of test cases
        int testCases = in.nextInt();
        while (testCases-- > 0) {
            int n = in.nextInt(); // Length of the string
            int k = in.nextInt(); // Number of flips allowed
            String s = in.next(); // The input string

            // Determine the character to check against based on k's parity and the first character
            char targetChar = (k % 2 == s.charAt(0) - '0') ? '0' : '1';

            // Variable to count the number of flips made
            int flipsMade = 0;

            // Iterate through the string and count transitions
            for (int j = 1; j < n && flipsMade < k; j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    flipsMade++;
                }
            }

            // If no flips are left, find the last occurrence of the target character
            if (flipsMade == k) {
                out.println(s.lastIndexOf(targetChar) + 1); // Adding 1 for 1-based index
            } else {
                out.println(-1); // Not enough flips available
            }
        }

        out.close(); // Close the PrintWriter
    }
}
