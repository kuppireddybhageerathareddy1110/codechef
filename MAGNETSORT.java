import java.util.*;

public class Main {
    
    // Method to check if a subarray sorted between indices makes the whole array sorted
    public static int check(int[] A, int first, int last) {
        int[] temp = Arrays.copyOf(A, A.length);
        Arrays.sort(temp, first, last + 1);
        if (Arrays.equals(temp, Arrays.stream(A).sorted().toArray())) {
            return 1;
        }
        return 0;
    }

    public static void solve(int[] A, String S, int N) {
        // Check if the array is already sorted
        if (isSorted(A)) {
            System.out.println(0);
            return;
        }
        
        // Count 'N' characters in S
        int countN = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'N') countN++;
        }
        
        // If there are no 'N' characters or all are 'N'
        if (countN == 0 || countN == N) {
            System.out.println(-1);
            return;
        }
        
        // Find the first and last occurrence of 'N' and 'S' in S
        int firstN = -1, lastN = -1, firstS = -1, lastS = -1;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'N') {
                if (firstN == -1) firstN = i;
                lastN = i;
            } else {
                if (firstS == -1) firstS = i;
                lastS = i;
            }
        }
        
        int ans = 2;
        if (check(Arrays.copyOf(A, A.length), firstN, lastS) == 1 || 
            check(Arrays.copyOf(A, A.length), firstS, lastN) == 1) {
            ans = 1;
        }
        System.out.println(ans);
    }

    // Method to check if the entire array is sorted
    public static boolean isSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            String S = sc.next();
            solve(A, S, N);
        }
        sc.close();
    }
}