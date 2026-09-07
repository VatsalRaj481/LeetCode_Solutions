class Solution{
    public int[] maxSlidingWindow(int[] nums,int k){
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }
}


// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int[] result = new int[nums.length-k+1];
//         int left=0;
//         for(int right=k-1;right<nums.length;right++){
//             result[left]=findMax(left,right,nums);
//             left++;
//         }
//         return result;
//     }
//     private int findMax(int left,int right,int[] nums){
//         int max=nums[left];
//         for(int i=left;i<=right;i++){
//             max=Math.max(nums[i],max);
//         }
//         return max;
//     }
// }