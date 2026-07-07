// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         Map<Integer,Integer> map = new HashMap<>();
//         int count=0;
//         for(int num:nums){
//             int complement = k-num;
//             if(map.getOrDefault(complement,0)>0){
//                 count++;
//                 map.put(complement,map.get(complement)-1);
//             }
//             else{
//                 map.put(num,map.getOrDefault(num,0)+1);
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, count = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else
                left++;
        }
        return count;
    }
}