import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[][] rowStrengths = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            int soldierCount = countSoldiers(mat[i]);
            rowStrengths[i][0] = soldierCount;
            rowStrengths[i][1] = i;
        }
        
        // Sort by soldier count ascending; if equal, sort by row index ascending
        Arrays.sort(rowStrengths, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowStrengths[i][1];
        }
        
        return result;
    }
    
    private int countSoldiers(int[] row) {
        int left = 0, right = row.length - 1;
        int count = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return count;
    }
}