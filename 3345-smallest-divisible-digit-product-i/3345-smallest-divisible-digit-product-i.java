class Solution {
    public int smallestNumber(int n, int t) {
        while(digPro(n)%t!=0){
            n++;
        }
        return n;
    }
    private int digPro(int num){
        int product=1;
        while(num!=0){
            product*=num%10;
            num/=10;
        }
        return product;
    }
}