class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length, countA = 0, countB = 0;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            boolean alice = false, bob = false;
            if (0 <= i && i < n - 1) {
                if (rain[i] == 1 && rain[i + 1] == 1) {
                    alice = true;
                }
            }
            if (rain[i] == 1) {
                bob = true;
            }
            if (alice || bob) {
                if (alice && bob) {
                    if (countA <= countB) {
                        answer[i] = "Alice";
                        countA++;
                    } else {
                        answer[i] = "Bob";
                        countB++;
                    }
                } else {
                    if (alice) {
                        answer[i] = "Alice";
                        countA++;
                    } else {
                        answer[i] = "Bob";
                        countB++;
                    }
                }
            } else {
                answer[i] = "None";
            }
        }
        return answer;
    }
}