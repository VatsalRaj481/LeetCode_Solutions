class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();
        int degree=0;

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            if(!first.containsKey(nums[i])){
                first.put(nums[i],i);
            }
            last.put(nums[i],i);
            degree=Math.max(degree,freq.get(nums[i]));
        }

        int answer=nums.length;
        for(int num:freq.keySet()){
            if(freq.get(num)==degree){
                int length=last.get(num)-first.get(num)+1;
                answer=Math.min(length,answer);
            }
        }
        return answer;
    }
}