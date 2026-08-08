class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n=s.length,m=t.length;
        if(m>n){
            return new int[0];
        }
        int[] suffix = new int[n+1];
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1];
            if(j>=0 && s[i]==t[j]){
                suffix[i]++;
                j--;
            }
        }
        int[] ans = new int[m];
        int i=0;
        j=0;
        boolean usedMismatch = false;
        while(i<n && j<m){
            int remaining=m-j-1;
            if(s[i]==t[j]){
                ans[j++]=i++;
            }
            else if(!usedMismatch && suffix[i+1]>=remaining){
                ans[j++]=i++;
                usedMismatch=true;
            }
            else{
                i++;
            }
        }
        return j==m?ans:new int[0];
    }
}