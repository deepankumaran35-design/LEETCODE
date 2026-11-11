import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort items by value in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(values[b], values[a]));
        
        Map<Integer, Integer> labelCounts = new HashMap<>();
        int totalSum = 0;
        int count = 0;
        
        for (int i = 0; i < n && count < numWanted; i++) {
            int idx = indices[i];
            int val = values[idx];
            int label = labels[idx];
            
            int currentLabelCount = labelCounts.getOrDefault(label, 0);
            if (currentLabelCount < useLimit) {
                labelCounts.put(label, currentLabelCount + 1);
                totalSum += val;
                count++;
            }
        }
        
        return totalSum;
    }
}