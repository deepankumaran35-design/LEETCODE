class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int j = 2; // Points to the next position to write a valid element
        
        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element two positions back
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        return j;
    }
}