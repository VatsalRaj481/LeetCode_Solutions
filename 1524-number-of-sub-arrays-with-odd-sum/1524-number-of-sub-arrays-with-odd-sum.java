class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd=0,even=1,count=0,sum=0;
        int MOD = 1000000007;
        for(int num:arr){
            sum+=num;
            if(sum%2==0){
                count+=odd;
                even++;
            }
            else{
                count+=even;
                odd++;
            }
            count%=MOD;
        }
        return count;
    }
}