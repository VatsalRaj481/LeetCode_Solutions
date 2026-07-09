class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] component = new int[nums.length];
        component[0]=0;
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1])<=maxDiff){
                component[i]=component[i-1];
            }
            else{
                component[i]=component[i-1]+1;
            }
        }
        int k=0;
        for(int[] query:queries){
            int i=query[0];
            int j=query[1];
            ans[k]=component[i]==component[j];
            k++;
        }
        return ans;
    }
}