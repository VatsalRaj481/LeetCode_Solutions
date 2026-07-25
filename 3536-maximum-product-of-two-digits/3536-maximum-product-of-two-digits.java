// class Solution {
//     public int maxProduct(int n) {
//         String num = Integer.toString(n);
//         int product = Integer.MIN_VALUE;
//         int len = num.length();
//         for(int i=0;i<len;i++){
//             for(int j=0;j<len;j++){
//                 if(i!=j){
//                     product=Math.max(product,(num.charAt(i)-'0')*(num.charAt(j)-'0'));
//                 }
//             }
//         }
//         return product;
//     }
// }

class Solution{
    public int maxProduct(int n){
        int first=0,second=0;
        while(n>0){
            int dig=n%10;
            if(dig>first){
                second=first;
                first=dig;
            }
            else if(dig>second){
                second=dig;
            }
            n/=10;
        }
        return first*second;
    }
}