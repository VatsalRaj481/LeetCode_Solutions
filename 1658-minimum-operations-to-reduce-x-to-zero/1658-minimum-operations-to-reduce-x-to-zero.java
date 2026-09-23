class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int target=total-x;
        if(target<0)return -1;

        int left=0,sum=0,maxLen=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        if(maxLen==0 && target!=0){
            return -1;
        }
        return nums.length-maxLen;
    }
}