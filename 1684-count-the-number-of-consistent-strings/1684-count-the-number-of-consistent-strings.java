class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistent=0;
        for(String word:words){
            boolean flag=true;
            for(char c:word.toCharArray()){
                if(allowed.indexOf(c)<0){
                    flag=false;
                    break;
                }
            }
            if(flag)consistent++;
        }
        return consistent;
    }
}