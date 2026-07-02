class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long result =0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=n-1;i>=n-k;i--){
            result += (long)nums[i] * Math.max(mul,1); 
            mul-=1;
        }
        return result;
    }
}