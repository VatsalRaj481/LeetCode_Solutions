class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest=Integer.MAX_VALUE,largest=Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int num:nums){
            smallest = Math.min(smallest,num);
            largest=Math.max(largest,num);
            set.add(num);
        }
        for(int i=smallest;i<=largest;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}