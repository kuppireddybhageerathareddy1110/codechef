import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int tt = scanner.nextInt(); // Read number of test cases
        while (tt-- > 0) {
            int n = scanner.nextInt(); // Read the size of the array
            long[] a = new long[n]; // Declare the array
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong(); // Read the elements of the array
            }
            
            long[] finalArray = Arrays.copyOf(a, n); // Copy original array
            Arrays.sort(finalArray); // Sort the copied array
            
            List<Long> sec = new ArrayList<>(); // List to hold unsorted elements
            int j = 0; // Pointer for the sorted array
            
            // Find unsorted elements
            for (int i = 0; i < n; i++) {
                if (a[i] == finalArray[j]) {
                    j++;
                } else {
                    sec.add(a[i]);
                }
            }
            
            // Check if the unsorted elements are sorted
            if (isSorted(sec)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close(); // Close the scanner
    }
    
    // Helper method to check if a list is sorted
    private static boolean isSorted(List<Long> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
