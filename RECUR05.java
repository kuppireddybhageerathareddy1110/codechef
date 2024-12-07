import java.util.Scanner;

public class Main {
    static int fib(int n) {
        if (n == 1) return 0; // The first Fibonacci number is 0
        if (n == 2) return 1; // The second Fibonacci number is 1

        // Calculate the Fibonacci number using recursion
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
        scanner.close();
    }
}
