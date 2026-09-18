class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = new int[26];
        for(char c:licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                freq[Character.toLowerCase(c)-'a']++;
            }
        }
        String answer=null;
        for(String word:words){
            int[] wordFreq = new int[26];
            for(char c:word.toCharArray()){
                wordFreq[c-'a']++;
            }
            boolean complete = true;
            for(int i=0;i<26;i++){
                if(wordFreq[i]<freq[i]){
                    complete=false;
                    break;
                }
            }
            if(complete){
                if(answer==null || word.length()<answer.length()){
                    answer=word;
                }
            }
        }
        return answer;
    }
}