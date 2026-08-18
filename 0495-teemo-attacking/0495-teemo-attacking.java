class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int t=0;t<timeSeries.length;t++){
            if(t==timeSeries.length-1)total+=duration;
            else{
                int gap =timeSeries[t+1]-timeSeries[t];
                total+=Math.min(gap,duration);
            }
        }
        return total;
    }
}