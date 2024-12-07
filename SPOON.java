import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] dimensions = br.readLine().trim().split(" ");
            int R = Integer.parseInt(dimensions[0]);
            int C = Integer.parseInt(dimensions[1]);
            String[] matrix = new String[R];

            // Read the matrix and store it
            for (int i = 0; i < R; i++) {
                matrix[i] = br.readLine().trim().toLowerCase(); // Convert to lower case for case insensitive search
            }

            // Flag to check if "spoon" is found
            boolean found = false;

            // Check each row
            for (int i = 0; i < R; i++) {
                if (matrix[i].contains("spoon")) {
                    found = true;
                    break;
                }
            }

            // Check each column if "spoon" is not found yet
            if (!found) {
                for (int j = 0; j < C; j++) {
                    StringBuilder column = new StringBuilder();
                    for (int i = 0; i < R; i++) {
                        column.append(matrix[i].charAt(j));
                    }
                    if (column.toString().contains("spoon")) {
                        found = true;
                        break;
                    }
                }
            }

            // Output result for the test case
            if (found) {
                output.append("There is a spoon!\n");
            } else {
                output.append("There is indeed no spoon!\n");
            }
        }

        System.out.print(output);
    }
}
