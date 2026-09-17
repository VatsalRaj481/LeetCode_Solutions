class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)return 0;
        int result=1;
        int left=0;
        for(int right=1;right<nums.length;right++){
            if(nums[right]<=nums[right-1]){
                left=right;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}