class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, matchIdx = -1;
        
        while (sIdx < sLen) {
            // If the current characters match or pattern has '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            }
            // If pattern has '*', mark the star position and the current match position in s
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            }
            // If we haven't matched and saw a '*', backtrack to the last star position
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                matchIdx++;
                sIdx = matchIdx;
            }
            // If current characters don't match and there is no star, it's a mismatch
            else {
                return false;
            }
        }
        
        // Check for remaining characters in pattern
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == pLen;
    }
}