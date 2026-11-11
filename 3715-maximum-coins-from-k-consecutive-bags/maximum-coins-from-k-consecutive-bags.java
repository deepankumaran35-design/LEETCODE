import java.util.Arrays;

class Solution {
    public long maximumCoins(int[][] coins, int k) {
        // Sort intervals by their start position
        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = coins.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long length = (long) (coins[i][1] - coins[i][0] + 1);
            prefixSum[i + 1] = prefixSum[i] + length * coins[i][2];
        }
        
        long maxCoins = 0;
        
        // Case 1: Window starts at the beginning of some interval (l_i) and has length k
        for (int i = 0; i < n; i++) {
            long start = coins[i][0];
            long end = start + k - 1;
            maxCoins = Math.max(maxCoins, getCoins(coins, prefixSum, start, end));
        }
        
        // Case 2: Window ends at the end of some interval (r_i) and has length k
        for (int i = 0; i < n; i++) {
            long end = coins[i][1];
            long start = end - k + 1;
            maxCoins = Math.max(maxCoins, getCoins(coins, prefixSum, start, end));
        }
        
        return maxCoins;
    }
    
    private long getCoins(int[][] coins, long[] prefixSum, long L, long R) {
        int n = coins.length;
        // Find the first interval whose end is >= L
        int leftIdx = binarySearchLeft(coins, L);
        // Find the last interval whose start is <= R
        int rightIdx = binarySearchRight(coins, R);
        
        if (leftIdx > rightIdx) {
            // The window [L, R] falls entirely in a gap between intervals
            return 0;
        }
        
        long total = prefixSum[rightIdx + 1] - prefixSum[leftIdx];
        
        // Subtract the parts that overflow outside [L, R] on the left
        if (coins[leftIdx][0] < L) {
            long overlap = L - coins[leftIdx][0];
            total -= overlap * coins[leftIdx][2];
        }
        
        // Subtract the parts that overflow outside [L, R] on the right
        if (coins[rightIdx][1] > R) {
            long overlap = coins[rightIdx][1] - R;
            total -= overlap * coins[rightIdx][2];
        }
        
        return total;
    }
    
    private int binarySearchLeft(int[][] coins, long L) {
        int low = 0, high = coins.length - 1;
        int ans = coins.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (coins[mid][1] >= L) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private int binarySearchRight(int[][] coins, long R) {
        int low = 0, high = coins.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (coins[mid][0] <= R) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}