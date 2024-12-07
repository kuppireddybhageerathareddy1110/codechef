import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt();
            String S = scanner.next();

            if (canEraseWholeString(S)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    public static boolean canEraseWholeString(String S) {
        int[] frequency = new int[26]; // Array to count frequency of each character (a-z)

        // Count occurrences of each character in the string
        for (char ch : S.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // Check if all characters have even frequencies
        for (int count : frequency) {
            if (count % 2 != 0) {
                return false; // If any character has an odd count, return false
            }
        }

        return true; // All characters have even frequency, so we can erase the string
    }
}
