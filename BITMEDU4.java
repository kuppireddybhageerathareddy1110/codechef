import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" ");
        int n = scanner.nextInt();

        // Call the method to flip the MSB and LSB
        int result = flipBits(n);
        
        // Print the result
        System.out.println( result);

        scanner.close();
    }
    
    public static int flipBits(int n) {
        // Convert N to binary string
        String binaryRep = Integer.toBinaryString(n);
        
        // Convert binary string to a character array for modification
        char[] binaryArray = binaryRep.toCharArray();
        
        // Flip the MSB (first character) and LSB (last character)
        binaryArray[0] = (binaryArray[0] == '0') ? '1' : '0'; // Flip MSB
        binaryArray[binaryArray.length - 1] = (binaryArray[binaryArray.length - 1] == '0') ? '1' : '0'; // Flip LSB
        
        // Convert the modified binary array back to a string
        String flippedBinary = new String(binaryArray);
        
        // Convert the flipped binary string to an integer
        return Integer.parseInt(flippedBinary, 2);
    }
}
