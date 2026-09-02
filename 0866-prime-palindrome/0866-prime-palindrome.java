class Solution {
    public int primePalindrome(int n) {
        // 11 is the only even-length prime palindrome
        if (n <= 11) {
            if (n <= 2) return 2;
            if (n <= 3) return 3;
            if (n <= 5) return 5;
            if (n <= 7) return 7;
            return 11;
        }
        // Generate odd-length palindromes
        for (int root = 1; root < 100000; root++) {
            String s = String.valueOf(root);
            // Create palindrome by appending reverse(root without last digit)
            String palindrome =
                    s + new StringBuilder(s.substring(0, s.length() - 1))
                            .reverse();
            int num = Integer.parseInt(palindrome);
            if (num >= n && isPrime(num)) {
                return num;
            }
        }
        return -1;
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num % 2 == 0) return num == 2;
        if (num % 3 == 0) return num == 3;
        for (int i = 5; (long) i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}