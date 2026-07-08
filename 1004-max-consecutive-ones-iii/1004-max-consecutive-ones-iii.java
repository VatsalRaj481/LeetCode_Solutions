class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0,zeros=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeros++;
                if(zeros>k){
                    while(zeros>k){
                        if(nums[left]==0){
                            zeros--;
                        }
                        left++;
                    }
                }
            }
            int len=right-left+1;
            max=Math.max(len,max);
        }
        return max;
    }
}