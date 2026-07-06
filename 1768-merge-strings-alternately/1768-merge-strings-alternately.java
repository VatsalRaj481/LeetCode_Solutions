class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1=word1.length(),n2=word2.length(),i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while(i<n1 && j<n2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i<n1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<n2){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}