import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        
        // 1. Calculate (n-1)! and initialize the list of numbers [1, 2, ..., n]
        for (int i = 1; i < n; i++) {
            factorial *= i;
            numbers.add(i);
        }
        numbers.add(n);
        
        // Convert k to 0-indexed
        k--;
        
        StringBuilder sb = new StringBuilder();
        
        // 2. Construct the k-th permutation step-by-step
        for (int i = n; i > 0; i--) {
            int index = k / factorial;
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            if (i == 1) {
                break;
            }
            
            k %= factorial;
            factorial /= (i - 1);
        }
        
        return sb.toString();
    }
}