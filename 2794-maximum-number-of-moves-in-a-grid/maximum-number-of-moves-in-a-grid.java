class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i] will store whether the cell (i, col) is reachable from any cell in the first column
        boolean[] dp = new boolean[m];
        for (int i = 0; i < m; i++) {
            dp[i] = true; // All cells in the first column are valid starting points
        }
        
        int maxMoves = 0;
        
        for (int col = 0; col < n - 1; col++) {
            boolean[] nextDp = new boolean[m];
            boolean canMoveAny = false;
            
            for (int row = 0; row < m; row++) {
                if (!dp[row]) continue;
                
                // Check move to (row - 1, col + 1)
                if (row - 1 >= 0 && grid[row - 1][col + 1] > grid[row][col]) {
                    nextDp[row - 1] = true;
                    canMoveAny = true;
                }
                // Check move to (row, col + 1)
                if (grid[row][col + 1] > grid[row][col]) {
                    nextDp[row] = true;
                    canMoveAny = true;
                }
                // Check move to (row + 1, col + 1)
                if (row + 1 < m && grid[row + 1][col + 1] > grid[row][col]) {
                    nextDp[row + 1] = true;
                    canMoveAny = true;
                }
            }
            
            if (!canMoveAny) {
                break;
            }
            
            dp = nextDp;
            maxMoves++;
        }
        
        return maxMoves;
    }
}