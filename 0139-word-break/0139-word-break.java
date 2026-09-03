class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]){
                    String part = s.substring(j,i);
                    for(String word:wordDict){
                        if(part.equals(word)){
                            dp[i]=true;
                            break;
                        }
                    } 
                }
            }
        }
        return dp[s.length()];
    }
}