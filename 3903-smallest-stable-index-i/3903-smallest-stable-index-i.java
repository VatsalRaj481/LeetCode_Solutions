class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int max=findMax(i,nums);
            int min=findMin(i,nums);
            int instabilityScore = max-min;
            if(instabilityScore<=k)return i;
        }
        return -1;
    }
    private int findMin(int n,int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=n;i<nums.length;i++){
            min=Math.min(nums[i],min);
        }
        return min;
    }
    private int findMax(int n,int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            max=Math.max(nums[i],max);
        }
        return max;
    }
}