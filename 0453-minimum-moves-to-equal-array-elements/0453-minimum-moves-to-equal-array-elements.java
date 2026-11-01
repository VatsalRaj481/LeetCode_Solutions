class Solution{
    public int minMoves(int[] nums){
        if(nums.length<=1)return 0;
        int min=nums[0];
        for(int num:nums){
            min=Math.min(min,num);
        }
        int moves=0;
        for(int num:nums){
            moves+=num-min;
        }
        return moves;
    }
}

// class Solution {
//     public int minMoves(int[] nums) {
//         int min=nums[0],sum=0;
//         for(int num:nums){
//             min=Math.min(min,num);
//             sum+=num;
//         }
//         return sum-(nums.length*min);
//     }
// }