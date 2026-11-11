class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        
        int[] arr = new int[n];
        int steps = 0;
        
        while (true) {
            boolean isOriginal = true;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
                
                if (arr[i] != i) {
                    isOriginal = false;
                }
            }
            
            steps++;
            
            if (isOriginal) {
                return steps;
            }
            
            // Copy arr to perm for the next iteration
            System.arraycopy(arr, 0, perm, 0, n);
        }
    }
}