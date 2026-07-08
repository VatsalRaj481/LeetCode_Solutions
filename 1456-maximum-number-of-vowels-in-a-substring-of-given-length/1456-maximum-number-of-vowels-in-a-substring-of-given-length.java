class Solution {
    public int maxVowels(String s, int k) {
        int count=0,maxCount=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i)))count++;
        }
        maxCount=count;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i-k)))count--;
            if(isVowel(s.charAt(i)))count++;
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
    private boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}