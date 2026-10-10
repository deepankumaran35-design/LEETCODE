class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Repeatedly divide n by 5, 25, 125, etc.
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }
}