class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Signs can only appear at the beginning or immediately after an exponent ('e' or 'E')
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // A dot is invalid if we have already seen a dot or an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // An exponent is invalid if we've already seen one, or if we haven't seen any digit before it
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit so that the exponent part is required to have its own digits after 'e'/'E'
                seenDigit = false;
            } else {
                // Any other character is invalid
                return false;
            }
        }
        
        // The string must end with a valid digit
        return seenDigit;
    }
}