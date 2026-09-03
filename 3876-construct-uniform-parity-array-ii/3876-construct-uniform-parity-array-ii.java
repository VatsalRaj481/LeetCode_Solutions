class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd=0,even=0,min=Integer.MAX_VALUE;
        for(int num:nums1){
            min=Math.min(min,num);
            if(num%2==0)even++;
            else odd++;
        }
        if(odd==nums1.length||even==nums1.length)return true;
        return min%2!=0;
    }
}