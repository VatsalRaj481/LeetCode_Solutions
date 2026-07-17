class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
        );
        int left=0,right=n-1;

        for(int i=0;i<candidates && left<=right;i++){
            pq.offer(new int[]{costs[left],left});
            left++;
        }

        for(int i=0;i<candidates && left<=right;i++){
            pq.offer(new int[]{costs[right],right});
            right--;
        }

        long ans=0;

        while(k-->0){
            int[] curr = pq.poll();
            ans+=curr[0];
            int idx=curr[1];

            //if left worker
            if(idx<left){
                if(left<=right){
                    pq.offer(new int[]{costs[left],left});
                    left++;
                }
            }

            else{
                if(left<=right){
                    pq.offer(new int[]{costs[right],right});
                    right--;
                }
            }
        }
        return ans;
    }
}