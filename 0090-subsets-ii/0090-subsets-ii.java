class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,current,result);
        return result;
    }
    private void backtrack(int start,int[] nums,List<Integer> current,List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i-1]==nums[i])continue;
            current.add(nums[i]);
            backtrack(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
    }
}