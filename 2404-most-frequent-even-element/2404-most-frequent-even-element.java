class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(num%2==0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        int ans=-1,maxFreq=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int num =entry.getKey();
            int count = entry.getValue();
            if(count>maxFreq ||(count==maxFreq && num<ans)){
                ans=num;
                maxFreq=count;
            }
        }
        return ans;
    }
}