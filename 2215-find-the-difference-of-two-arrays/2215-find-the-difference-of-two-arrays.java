class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        for(int i:set1){
            if(!set2.contains(i)){
                answer1.add(i);
            }
        }
        for(int i:set2){
            if(!set1.contains(i)){
                answer2.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(answer1);
        result.add(answer2);
        return result;
    }
}