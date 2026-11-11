import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int minCost(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // We start with index 1 being the "first" element of the current trio, 
        // and index 0 as the single element left behind from the previous operation.
        return solve(1, 0, nums);
    }

    private int solve(int i, int j, int[] nums) {
        int n = nums.length;
        // If fewer than 3 elements remain (i.e., i, i+1, etc. are out of bounds or only 1-2 elements left)
        if (i >= n) {
            return nums[j];
        }
        if (i == n - 1) {
            return Math.max(nums[j], nums[i]);
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int op1 = Math.max(nums[i], nums[i + 1]) + solve(i + 2, j, nums);
        int op2 = Math.max(nums[j], nums[i]) + solve(i + 2, i + 1, nums);
        int op3 = Math.max(nums[j], nums[i + 1]) + solve(i + 2, i, nums);

        return memo[i][j] = Math.min(op1, Math.min(op2, op3));
    }
}