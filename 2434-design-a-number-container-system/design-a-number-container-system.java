import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class NumberContainers {
    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }
    
    public int find(int number) {
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }
        
        PriorityQueue<Integer> pq = numberToIndices.get(number);
        
        // Lazy deletion / validation: clean up indices that no longer hold this number
        while (!pq.isEmpty()) {
            int index = pq.peek();
            if (indexToNumber.containsKey(index) && indexToNumber.get(index) == number) {
                return index;
            }
            pq.poll();
        }
        
        return -1;
    }
}