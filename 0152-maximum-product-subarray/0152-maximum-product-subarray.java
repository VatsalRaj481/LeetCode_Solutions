class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
        {
            return nums[0];
        }
        int max=nums[0],result=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=min;
                min=max;
                max=temp;
            }
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
            result=Math.max(result,max);
        }
        return result;
    }
}