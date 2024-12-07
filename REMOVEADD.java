import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            minoperations(n, a);
        }
	}
    public static void minoperations(int n, int[] a) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && (map.get(a[right]) == null || map.get(a[right]) == 0)) {
                map.put(a[right], map.getOrDefault(a[right], 0) + 1);
                right++;
            }
            ans = Math.min(ans, left + 2 * (n - right));
            ans = Math.min(ans, 2 * left + n - right);
            map.put(a[left], map.get(a[left]) - 1);
        }
        System.out.println(ans);
	}
}