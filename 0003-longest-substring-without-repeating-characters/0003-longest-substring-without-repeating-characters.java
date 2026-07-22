class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charIndex[currentChar] > start) {
                start = charIndex[currentChar];
            }
            charIndex[currentChar] = end + 1;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
