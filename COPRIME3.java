import java.util.Scanner;

 class GCDTripletCounter {
    private static final int MAX_A = 1000000;
    private static int[] frequency = new int[MAX_A + 1];
    private static long[] gcdCount = new long[MAX_A + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();

        // Count the frequency of each number
        for (int i = 0; i < numberCount; i++) {
            int number = scanner.nextInt();
            frequency[number]++;
        }
        scanner.close();

        // Calculate the number of triplets for each possible GCD
        for (int gcd = MAX_A; gcd >= 1; gcd--) {
            int multiples = 0;
            // Count the multiples of gcd
            for (int multiple = gcd; multiple <= MAX_A; multiple += gcd) {
                multiples += frequency[multiple];
            }

            // Calculate combinations of triplets if there are at least 3 multiples
            if (multiples >= 3) {
                gcdCount[gcd] = (long) multiples * (multiples - 1) * (multiples - 2) / 6;
            }

            // Subtract contributions from multiples of this gcd
            for (int multiple = 2 * gcd; multiple <= MAX_A; multiple += gcd) {
                gcdCount[gcd] -= gcdCount[multiple];
            }
        }

        // Output the result for GCD = 1
        System.out.println(gcdCount[1]);
    }
}
