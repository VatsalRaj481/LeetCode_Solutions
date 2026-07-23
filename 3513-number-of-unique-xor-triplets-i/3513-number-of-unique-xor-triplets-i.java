// //Brute Force
// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int n=nums.length;
//         Set<Integer> set = new HashSet<>(); 
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 for(int k=j;k<n;k++){
//                     set.add(nums[i]^nums[j]^nums[k]);
//                 }
//             }
//         }
//         return set.size();
//     }
// }

//the answer changes only when the value reaches a power of 2
class Solution{
    public int uniqueXorTriplets(int[] nums){
        int n=nums.length;
        if(n<=2)return n;
        int ans=1;
        while(ans<=n){
            ans<<=1;
        }
        return ans;
    }
}