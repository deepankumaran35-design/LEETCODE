class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int lastOne = -1;
        int lastTwo = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                lastOne = i;
                if (lastTwo != -1) {
                    minDiff = Math.min(minDiff, i - lastTwo);
                }
            } else if (nums[i] == 2) {
                lastTwo = i;
                if (lastOne != -1) {
                    minDiff = Math.min(minDiff, i - lastOne);
                }
            }
        }
        
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}