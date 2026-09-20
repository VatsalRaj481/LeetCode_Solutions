class Solution {
    public int reverseDegree(String s) {
        int reverseDegree=0;
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            reverseDegree+=(i+1)*(26-(c-'a'));
        }
        return reverseDegree;
    }
}