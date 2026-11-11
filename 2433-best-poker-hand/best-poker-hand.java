import java.util.HashMap;
import java.util.Map;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        // Check for Flush: all 5 cards have the same suit
        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) {
            return "Flush";
        }
        
        // Count frequencies of each rank
        Map<Integer, Integer> rankCounts = new HashMap<>();
        int maxFreq = 0;
        
        for (int rank : ranks) {
            int count = rankCounts.getOrDefault(rank, 0) + 1;
            rankCounts.put(rank, count);
            maxFreq = Math.max(maxFreq, count);
        }
        
        // Check for Three of a Kind or Pair
        if (maxFreq >= 3) {
            return "Three of a Kind";
        } else if (maxFreq == 2) {
            return "Pair";
        }
        
        return "High Card";
    }
}