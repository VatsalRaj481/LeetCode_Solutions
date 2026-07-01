class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==1)
        {
            return;
        }
        int nonZeroIndex=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[nonZeroIndex++]=nums[i];
            }
        }
        for(int i=nonZeroIndex;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}