class Solution {
    public int maxSubArray(int[] nums) {
        int currentsum=nums[0];
        int maximumsum=nums[0];
        for(int i=1; i<nums.length; i++){
            currentsum=Math.max(nums[i],currentsum+nums[i]);
            maximumsum=Math.max(maximumsum,currentsum);
        }
        return maximumsum;
    }
}