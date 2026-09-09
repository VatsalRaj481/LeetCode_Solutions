class Solution {
    public String convertToBase7(int num) {
        //return Integer.toString(num,7);
        if(num==0)return "0";
        boolean isNegative = num<0;
        long n = Math.abs((long)num);
        StringBuilder result = new StringBuilder();
        while(n>0){
            long remainder = n%7;
            result.append(remainder);
            n/=7;
        }
        if(isNegative){
            result.append('-');
        }
        return result.reverse().toString();
    }
}