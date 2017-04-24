import java.util.Comparator;
import java.util.PriorityQueue;

public class PQtest {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("dog");
        pq.add("apple");
        pq.add("fox");
        pq.add("easy");
        pq.add("boy");
        
        while (!pq.isEmpty()) {
            for (String s : pq) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println("pq.poll(): " + pq.poll());
        }
    }

}
