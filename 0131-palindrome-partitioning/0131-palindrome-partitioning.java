class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, current, result);
        return result;
    }
    private void backtrack(
            String s,
            int start,
            List<String> current,
            List<List<String>> result) {
        // Entire string has been partitioned
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Try every possible substring starting from start
        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            // Only choose palindrome substrings
            if (isPalindrome(substring)) {
                // Choose
                current.add(substring);
                // Explore
                backtrack(s, end + 1, current, result);
                // Undo
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}