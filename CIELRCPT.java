import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        // Define menu prices, which are powers of 2 from 2^0 to 2^11
        int[] menuPrices = {2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

        for (int t = 0; t < T; t++) {
            int p = scanner.nextInt();
            int menuCount = 0;

            // Find minimum number of menus to reach total price p
            for (int price : menuPrices) {
                if (p == 0) break;
                menuCount += p / price;  // Use as many items of this menu as possible
                p %= price;              // Update p to the remaining amount
            }

            System.out.println(menuCount);
        }

        scanner.close();
    }
}
