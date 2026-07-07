class Solution {
    public long sumAndMultiply(int n) {
        int rev=0;
        while(n>0){
            int dig=n%10;
            if(dig!=0){
                rev=rev*10+dig;
            }
            n/=10;
        }
        long x=0,sum=0;
        while(rev>0){
            int dig=rev%10;
            x=x*10+dig;
            sum+=dig;
            rev/=10;
        }
        return x*sum;
    }
}