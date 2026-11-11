import java.util.Arrays;

class Solution {
    public int maxScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long maxIntersectionSum = Long.MIN_VALUE;
        
        // 1. Check each row for shared contiguous segments of length >= 2
        for (int i = 0; i < m; i++) {
            long[] rowSum = new long[n];
            for (int j = 0; j < n; j++) {
                rowSum[j] = grid[i][j];
            }
            maxIntersectionSum = Math.max(maxIntersectionSum, getMaxSubarraySumAtLeastTwo(rowSum));
        }
        
        // 2. Check each column for shared contiguous segments of length >= 2
        for (int j = 0; j < n; j++) {
            long[] colSum = new long[m];
            for (int i = 0; i < m; i++) {
                colSum[i] = grid[i][j];
            }
            maxIntersectionSum = Math.max(maxIntersectionSum, getMaxSubarraySumAtLeastTwo(colSum));
        }
        
        // 3. Check for a single shared cell, but with the constraint that 
        // it must NOT lie on the first/last row, or the first/last column.
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                maxIntersectionSum = Math.max(maxIntersectionSum, grid[i][j]);
            }
        }
        
        return (int) maxIntersectionSum;
    }
    
    // Modified Kadane's algorithm to find the maximum subarray sum of length at least 2
    private long getMaxSubarraySumAtLeastTwo(long[] nums) {
        int len = nums.length;
        if (len < 2) return Long.MIN_VALUE;
        
        long maxSum = Long.MIN_VALUE;
        long currentMinPrefix = 0;
        long totalSum = 0;
        
        // To ensure subarray length >= 2, we track the minimum prefix sum 
        // with an index at least 2 steps behind or standard prefix difference.
        // Alternatively, we can iterate and maintain the best pair sum for all ends.
        
        long minPrev = 0;
        long currentPrefix = 0;
        
        for (int j = 0; j < len; j++) {
            currentPrefix += nums[j];
            if (j >= 1) {
                maxSum = Math.max(maxSum, currentPrefix - minPrev);
                minPrev = Math.min(minPrev, currentPrefix - nums[j]);
            }
        }
        
        return maxSum;
    }
}