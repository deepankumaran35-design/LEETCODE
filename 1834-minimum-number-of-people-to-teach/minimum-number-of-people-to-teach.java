import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        // Step 1: Store languages in a HashSet for each user for O(1) lookup
        // (User indices are 1-based, so we use size m + 1)
        Set<Integer>[] userLangs = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            userLangs[i] = new HashSet<>();
            for (int lang : languages[i - 1]) {
                userLangs[i].add(lang);
            }
        }
        
        // Step 2: Find all friendships that currently cannot communicate
        Set<Integer> cantCommunicateUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0];
            int v = f[1];
            
            if (!canCommunicate(u, v, userLangs)) {
                cantCommunicateUsers.add(u);
                cantCommunicateUsers.add(v);
            }
        }
        
        // If everyone can already communicate with their friends
        if (cantCommunicateUsers.isEmpty()) {
            return 0;
        }
        
        // Step 3: Try teaching each language from 1 to n to find the minimum users to teach
        int minTeachings = Integer.MAX_VALUE;
        
        for (int lang = 1; lang <= n; lang++) {
            int currentTeachCount = 0;
            for (int user : cantCommunicateUsers) {
                if (!userLangs[user].contains(lang)) {
                    currentTeachCount++;
                }
            }
            minTeachings = Math.min(minTeachings, currentTeachCount);
        }
        
        return minTeachings;
    }
    
    private boolean canCommunicate(int u, int v, Set<Integer>[] userLangs) {
        for (int lang : userLangs[u]) {
            if (userLangs[v].contains(lang)) {
                return true;
            }
        }
        return false;
    }
}