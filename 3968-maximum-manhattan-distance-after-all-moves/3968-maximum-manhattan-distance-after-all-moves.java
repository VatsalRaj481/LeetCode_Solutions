class Solution {
    public int maxDistance(String moves) {
        int up = 0, down = 0, left = 0, right = 0, blank = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                up++;
            } else if (ch == 'D') {
                down++;
            } else if (ch == 'L') {
                left++;
            } else if (ch == 'R') {
                right++;
            } else {
                blank++;
            }
        }

        return Math.abs(right - left) + Math.abs(up - down) + blank;
    }
}