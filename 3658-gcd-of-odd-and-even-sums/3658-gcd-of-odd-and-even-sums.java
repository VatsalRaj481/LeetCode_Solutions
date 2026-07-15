class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven=0,sumOdd=0;
        int odd=0,even=0,i=1;
        while(odd!=n && even!=n){
            if(i%2==0){
                sumEven+=i;
                even++;
            }
            else{
                sumOdd+=i;
                odd++;
            }
            i++;
        }
        return gcd(sumOdd,sumEven);
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
}