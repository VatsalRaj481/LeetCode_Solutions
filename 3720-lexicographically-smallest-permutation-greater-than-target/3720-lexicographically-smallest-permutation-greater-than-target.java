class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int i = 0;

        while (i < n) {
            int x = target.charAt(i) - 'a';
            if (freq[x] == 0) break;
            freq[x]--;
            i++;
        }

        for (int j = i; j >= 0; j--) {
            if (j < i)
                freq[target.charAt(j) - 'a']++;

            if (j == n)
                continue;

            int x = target.charAt(j) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (freq[c] == 0) continue;

                StringBuilder ans = new StringBuilder(target.substring(0, j));
                ans.append((char) ('a' + c));
                freq[c]--;

                for (int k = 0; k < 26; k++)
                    while (freq[k]-- > 0)
                        ans.append((char) ('a' + k));

                return ans.toString();
            }
        }

        return "";
    }
}