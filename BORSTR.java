import java.util.HashMap;
import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int length = scanner.nextInt();
            String inputString = scanner.next();
            
            int maxSequenceLength = 1; // Maximum length of consecutive characters
            int currentCount = 1; // Current consecutive character count
            
            // To store the frequency of consecutive character sequences
            HashMap<String, Integer> sequenceMap = new HashMap<>();
            
            for (int i = 1; i < length; i++) {
                if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                    currentCount++;
                } else {
                    // Create the substring of consecutive characters
                    String sequence = inputString.substring(i - currentCount, i);
                    sequenceMap.put(sequence, sequenceMap.getOrDefault(sequence, 0) + 1);
                    
                    // Update max sequence length
                    maxSequenceLength = Math.max(maxSequenceLength, currentCount);
                    
                    currentCount = 1; // Reset current count for new character
                }
            }
            // Handle the last sequence
            String lastSequence = inputString.substring(length - currentCount);
            sequenceMap.put(lastSequence, sequenceMap.getOrDefault(lastSequence, 0) + 1);
            maxSequenceLength = Math.max(maxSequenceLength, currentCount);
            
            int maxLengthInMap = 0;
            String resultSequence = "";
            
            for (String key : sequenceMap.keySet()) {
                maxLengthInMap = Math.max(maxLengthInMap, key.length());
                if (sequenceMap.get(key) > 1 && key.length() == maxLengthInMap) {
                    resultSequence = key;
                }
            }
            
            // Compare lengths to determine output
            if (resultSequence.length() == maxSequenceLength) {
                System.out.println(maxSequenceLength);
            } else {
                System.out.println(Math.max(resultSequence.length(), maxSequenceLength) - 1);
            }
        }
    }
}
