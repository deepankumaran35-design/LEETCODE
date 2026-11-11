import java.util.Arrays;

class Solution {
    public int countElements(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int minVal = nums[0];
        int maxVal = nums[nums.length - 1];
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > minVal && nums[i] < maxVal) {
                count++;
            }
        }
        
        return count;
    }
}