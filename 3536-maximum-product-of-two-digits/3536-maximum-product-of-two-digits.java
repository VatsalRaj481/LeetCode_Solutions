class Solution {
    public int maxProduct(int n) {
        String num = Integer.toString(n);
        int product = Integer.MIN_VALUE;
        int len = num.length();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i!=j){
                    product=Math.max(product,(num.charAt(i)-'0')*(num.charAt(j)-'0'));
                }
            }
        }
        return product;
    }
}