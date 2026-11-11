import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        // Map to store the count of black cells for each 2x2 block (identified by its top-left corner [x, y])
        Map<Long, Integer> blockCountMap = new HashMap<>();
        
        for (int[] coord : coordinates) {
            int r = coord[0];
            int c = coord[1];
            
            // Each black cell can affect up to 4 different 2x2 blocks where it is part of the block:
            // 1. Top-left:    (r-1, c-1)
            // 2. Top-right:   (r-1, c)
            // 3. Bottom-left: (r,   c-1)
            // 4. Bottom-right:(r,   c)
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int tr = r - i;
                    int tc = c - j;
                    
                    // Check if the top-left corner defines a valid 2x2 block within the m x n grid
                    if (tr >= 0 && tr < m - 1 && tc >= 0 && tc < n - 1) {
                        long key = ((long) tr << 32) | (tc & 0xFFFFFFFFL);
                        blockCountMap.put(key, blockCountMap.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        
        long[] result = new long[5];
        
        // Count how many blocks have 1, 2, 3, or 4 black cells
        for (int count : blockCountMap.values()) {
            if (count > 0 && count <= 4) {
                result[count]++;
            }
        }
        
        // Total possible 2x2 blocks in the m x n grid
        long totalBlocks = (long) (m - 1) * (n - 1);
        
        // Blocks with 0 black cells = Total blocks - Blocks with at least one black cell
        long blocksWithBlack = blockCountMap.size();
        result[0] = totalBlocks - blocksWithBlack;
        
        return result;
    }
}