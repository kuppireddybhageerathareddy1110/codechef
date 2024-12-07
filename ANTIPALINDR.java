import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int[] charFrequency = new int[26]; // Only need 26 for alphabet characters
            for (int i = 0; i < n; i++) {
                charFrequency[s.charAt(i) - 'a']++;
            }

            int oddCount = 0;
            int evenCount = 0;
            for (int frequency : charFrequency) {
                if (frequency > 0) {
                    if (frequency % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }
            }

            if (n % 2 == 0) { // Case for even-length strings
                System.out.println(oddCount > 0 ? 0 : 1);
            } else { // Case for odd-length strings
                if (oddCount > 1) {
                    System.out.println(0);
                } else if (oddCount == 1 && evenCount == 0) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            }
        }
        sc.close();
    }
}
