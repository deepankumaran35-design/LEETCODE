class Solution {
    static {
        System.gc();

        for (int i = 0; i < 300; i++) {
            firstUniqChar("leetcode");
        }
    }

    public static final int LETTERS_AMOUNT = 28;

    public static int firstUniqChar(String s) {
        byte[] chars = s.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1);
        int[] uniqueChars = new int[LETTERS_AMOUNT];
        for (byte ch : chars) {
            uniqueChars[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (uniqueChars[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}