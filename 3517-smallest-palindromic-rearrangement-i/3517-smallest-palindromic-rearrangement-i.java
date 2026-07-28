class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                left.append((char)('a'+i));
            }
            if(freq[i]%2==1){
                mid.append((char)('a'+i));
            }
        }
        StringBuilder right = new StringBuilder(left).reverse(); 
        return left.append(mid).append(right).toString();
    }
}