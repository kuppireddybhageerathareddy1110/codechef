import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume the newline character

        while (T-- > 0) {
            String s = scanner.nextLine();
            String result = createSmallestPalindrome(s);

            System.out.println(result);
        }

        scanner.close();
    }

    public static String createSmallestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // Try to make the string a palindrome
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;

            // Both characters are faded
            if (arr[i] == '.' && arr[j] == '.') {
                arr[i] = arr[j] = 'a'; // Assign 'a' to both positions for lexicographically smallest result
            }
            // One side is faded, the other is a letter
            else if (arr[i] == '.') {
                arr[i] = arr[j]; // Mirror the character from the other side
            }
            else if (arr[j] == '.') {
                arr[j] = arr[i]; // Mirror the character from the other side
            }
            // Both sides have different characters
            else if (arr[i] != arr[j]) {
                return "-1"; // Not possible to form a palindrome
            }
        }

        // If the length is odd, ensure the middle character is set (if faded)
        if (n % 2 == 1 && arr[n / 2] == '.') {
            arr[n / 2] = 'a';
        }

        return new String(arr);
    }
}
