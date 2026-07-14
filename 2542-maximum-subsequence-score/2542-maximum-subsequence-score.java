class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1]=nums1[i];
        }
        Arrays.sort(pairs,(a,b)->
            Integer.compare(b[0],a[0])
        );

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum=0;
        long ans=0;

        for(int[] pair:pairs){
            int num1=pair[1];
            int num2=pair[0];

            minHeap.offer(num1);
            sum+=num1;

            if(minHeap.size()>k){
                sum-=minHeap.poll();
            }
            if(minHeap.size()==k){
                ans=Math.max(ans,sum*num2);
            }
        }
        return ans;
    }
}