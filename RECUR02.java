import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // Calculate and display the sum of the first N natural numbers
        System.out.println("Sum of first " + n + " natural numbers is " + sum(n));

        scanner.close();
    }

    static int sum(int n) {
        System.out.println("Sum(" + n + ") is called");

        // Base case: if n is 1, return 1
        if (n == 1) {
            System.out.println("Base Condition reached");
            return 1;
        }

        // Recursive case: Sum(n) = n + Sum(n - 1)
        int sumN1 = sum(n - 1);

        System.out.println("Sum(" + n + ") = " + n + " + Sum(" + (n - 1) + ")");
        int sumN = n + sumN1;

        System.out.println("Sum(" + n + ") = " + n + " + " + sumN1);
        System.out.println("Sum(" + n + ") is returning " + sumN);

        return sumN;
    }
}
