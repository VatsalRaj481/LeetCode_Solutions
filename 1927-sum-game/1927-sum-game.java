class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum=0,rightSum=0;
        int leftQ=0,rightQ=0;
        for(int i=0;i<n;i++){
            char c =num.charAt(i);
            if(i<n/2){
                if(c == '?'){
                    leftQ++;
                }
                else{
                    leftSum+=c-'0';
                }
            }
            else{
                if(c=='?'){
                    rightQ++;
                }
                else{
                    rightSum+=c-'0';
                }
            }
        }
        int qDiff = leftQ-rightQ;
        int sumDiff = leftSum - rightSum;

        if(qDiff%2!=0)return true;
        return sumDiff!=-9*qDiff/2;
    }
}