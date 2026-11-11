class Solution {
    public int uniquePaths(int m, int n) {
        long paths = 1;
        for (int i = 1; i <= m - 1; i++) {
            paths = paths * (n + i - 1) / i;
        }
        return (int) paths;
    }
}
