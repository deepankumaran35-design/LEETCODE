import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the total sum is not evenly divisible by k, we can't partition it
        if (sum % k != 0) {
            return false;
        }
        
        int target = sum / k;
        
        // Sort in descending order to try larger elements first (helps prune the search space faster)
        Arrays.sort(nums);
        int n = nums.length;
        
        // If the largest element is greater than the target, it's impossible
        if (nums[n - 1] > target) {
            return false;
        }
        
        boolean[] visited = new boolean[n];
        return backtrack(nums, visited, 0, k, 0, target);
    }
    
    private boolean backtrack(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int target) {
        // If we have successfully filled k-1 subsets, the last one is guaranteed to have the correct sum
        if (k == 1) {
            return true;
        }
        
        // If the current subset reaches the target, move on to the next subset
        if (currentSum == target) {
            return backtrack(nums, visited, 0, k - 1, 0, target);
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(nums, visited, i + 1, k, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
                
                // Optimization: if currentSum is 0 and the element didn't lead to a solution, 
                // further elements won't either (symmetry breaking)
                if (currentSum == 0) {
                    break;
                }
            }
        }
        
        return false;
    }
}