import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] received = new boolean[n + 1];
        int currentFriend = 1;
        int step = 1;
        
        while (!received[currentFriend]) {
            received[currentFriend] = true;
            // On the i-th turn, pass it i * k steps away
            currentFriend = (currentFriend + (step * k) - 1) % n + 1;
            step++;
        }
        
        // Collect all friends who did not receive the ball
        List<Integer> losers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!received[i]) {
                losers.add(i);
            }
        }
        
        // Convert the list to an int array
        int[] result = new int[losers.size()];
        for (int i = 0; i < losers.size(); i++) {
            result[i] = losers.get(i);
        }
        
        return result;
    }
}
