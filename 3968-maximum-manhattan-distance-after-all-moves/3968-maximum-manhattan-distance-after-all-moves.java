class Solution {
    public int maxDistance(String moves) {
       int ans=0;
       int[][] sign = {
        {1,1},
        {1,-1},
        {-1,1},
        {-1,-1}
       };

       for(int[] s:sign){
        int cur=0;
        for(char c:moves.toCharArray()){
            if(c=='_'){
                cur++;
            }
            else{
                int dx=0,dy=0;
                if(c=='L')dx=-1;
                else if(c=='R')dx=1;
                else if(c=='U')dy=1;
                else dy=-1;
                cur+=s[0]*dx+s[1]*dy;
            }
        }
        ans=Math.max(ans,cur);
       }
       return ans; 
    }
}