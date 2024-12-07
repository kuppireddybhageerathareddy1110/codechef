import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] swipes = br.readLine().trim().split(" ");
            
            // Set to track people currently inside the office
            Set<Integer> inOffice = new HashSet<>();
            int maxPeople = 0;
            
            for (int i = 0; i < N; i++) {
                int id = Integer.parseInt(swipes[i]);
                
                // Toggle presence in office
                if (inOffice.contains(id)) {
                    inOffice.remove(id);  // Leave the office
                } else {
                    inOffice.add(id);     // Enter the office
                }
                
                // Update maximum number of people in the office
                maxPeople = Math.max(maxPeople, inOffice.size());
            }
            
            output.append(maxPeople).append("\n");
        }
        
        System.out.print(output);
    }
}
