import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Process each test case
        for (int t = 0; t < testCases; t++) {
            String hiddenWord = scanner.nextLine(); // Read hidden word S
            String guessWord = scanner.nextLine(); // Read guess word T
            
            StringBuilder result = new StringBuilder(); // To store the result string M
            
            // Compare each character
            for (int i = 0; i < 5; i++) {
                if (hiddenWord.charAt(i) == guessWord.charAt(i)) {
                    result.append('G'); // Correct guess
                } else {
                    result.append('B'); // Wrong guess
                }
            }
            
            // Print the result for the current test case
            System.out.println(result.toString());
        }
        
        scanner.close(); // Close the scanner
    }
}
