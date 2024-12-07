import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        // Precompute all primes up to sqrt(10^9) using classic Sieve of Eratosthenes
        int limit = (int) Math.sqrt(1_000_000_000) + 1;
        List<Integer> smallPrimes = sieve(limit);
        
        StringBuilder result = new StringBuilder();
        for (int test = 0; test < t; test++) {
            String[] range = br.readLine().trim().split(" ");
            int m = Integer.parseInt(range[0]);
            int n = Integer.parseInt(range[1]);
            
            // Segmented sieve to find primes in range [m, n]
            boolean[] isPrime = new boolean[n - m + 1];
            Arrays.fill(isPrime, true);

            for (int prime : smallPrimes) {
                if (prime * prime > n) break;
                
                int start = Math.max(prime * prime, (m + prime - 1) / prime * prime);
                for (int j = start; j <= n; j += prime) {
                    isPrime[j - m] = false;
                }
            }

            // Collecting results for the current test case
            for (int i = 0; i <= n - m; i++) {
                if (isPrime[i] && (i + m) > 1) {
                    result.append(i + m).append("\n");
                }
            }
            
            if (test < t - 1) {
                result.append("\n"); // Separate each test case with an empty line
            }
        }
        
        System.out.print(result);
    }

    // Sieve of Eratosthenes to find all primes up to `limit`
    public static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
}
