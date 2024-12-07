import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.HashSet;

public class Main {

    private static void maxSubarraySum(int[] array, int k) {
        long sum = 0;
        for (int value : array) sum += value;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashSet<Node> visited = new HashSet<>();
        pq.add(new Node(sum, 0, array.length - 1));
        visited.add(new Node(sum, 0, array.length - 1));

        StringBuilder result = new StringBuilder();
        while (k-- > 0 && !pq.isEmpty()) {
            Node top = pq.poll();
            result.append(top.sum);
            if (k > 0) result.append(' ');

            int l = top.l;
            int r = top.r;

            if (l != r) {
                Node node1 = new Node(top.sum - array[l], l + 1, r);
                if (visited.add(node1)) pq.add(node1);

                Node node2 = new Node(top.sum - array[r], l, r - 1);
                if (visited.add(node2)) pq.add(node2);
            }
        }
        
        System.out.println(result);
    }

    private static class Node implements Comparable<Node> {
        long sum;
        int l, r;

        public Node(long sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(other.sum, this.sum); // Max-heap behavior
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return l == node.l && r == node.r;
        }

        @Override
        public int hashCode() {
            return 31 * l + r; // Custom hash code for unique subarray (l, r)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] fields = reader.readLine().split("\\s+");
        int k = Integer.parseInt(fields[1]);

        String[] stringArray = reader.readLine().split("\\s+");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        
        maxSubarraySum(array, k);
    }
}
