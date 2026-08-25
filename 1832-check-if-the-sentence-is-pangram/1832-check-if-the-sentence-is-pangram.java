class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for(char c:sentence.toCharArray()){
            freq[c-'a']++;
        }
        for(int frequency:freq){
            if(frequency==0){
                return false;
            }
        }
        return true;
    }
}