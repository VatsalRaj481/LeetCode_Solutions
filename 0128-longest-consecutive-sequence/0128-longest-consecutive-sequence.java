class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest=0;
        for(int i:nums)
        {
            set.add(i);
        }
        for(int i:set)
        {
            if(!set.contains(i-1))
            {
                int length=1;
                while(set.contains(i+length))
                {
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
}