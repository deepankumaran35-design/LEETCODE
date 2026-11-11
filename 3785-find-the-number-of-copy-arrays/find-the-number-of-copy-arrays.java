class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        
        // The allowed range for copy[0]
        long minVal = bounds[0][0];
        long maxVal = bounds[0][1];
        
        for (int i = 1; i < n; i++) {
            // Difference between original[i] and original[0]
            long diff = (long) original[i] - original[0];
            
            // If copy[0] is c0, then copy[i] = c0 + diff.
            // We need: bounds[i][0] <= c0 + diff <= bounds[i][1]
            // Therefore: bounds[i][0] - diff <= c0 <= bounds[i][1] - diff
            long currentMin = bounds[i][0] - diff;
            long currentMax = bounds[i][1] - diff;
            
            // Intersect with the accumulated range for copy[0]
            minVal = Math.max(minVal, currentMin);
            maxVal = Math.min(maxVal, currentMax);
            
            // If at any point the valid range becomes empty, 0 arrays are possible
            if (minVal > maxVal) {
                return 0;
            }
        }
        
        // The number of valid choices for copy[0]
        return (int) (maxVal - minVal + 1);
    }
}