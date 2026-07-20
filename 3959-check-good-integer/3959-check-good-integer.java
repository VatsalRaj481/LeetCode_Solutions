class Solution {
    public boolean checkGoodInteger(int n) {
        return squareSum(n)-digitSum(n)>=50;
    }
    private int digitSum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    private int squareSum(int n){
        int s=0;
        while(n>0){
            s+=(n%10)*(n%10);
            n/=10;
        }
        return s;
    }
}