class Solution {
    public int countCommas(int n) {
        if(countDigits(n)<4)return 0;
        return n-999;
    }
    private int countDigits(int num){
        int count=0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }
}