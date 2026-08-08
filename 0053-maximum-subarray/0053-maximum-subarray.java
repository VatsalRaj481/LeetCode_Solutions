class Solution {
    public int maxSubArray(int[] nums) {
        int global=nums[0],current=nums[0];
        for(int i=1;i<nums.length;i++){
            current=Math.max(nums[i],current+nums[i]);
            global=Math.max(global,current);
        }
        return global;
    }
}