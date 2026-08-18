class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int rank = n-i;
            map.put(sorted[i],rank);
        }
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            int rank = map.get(score[i]);
            if(rank==1){
                answer[i]="Gold Medal";
            }
            else if(rank==2){
                answer[i]="Silver Medal";
            }
            else if(rank==3){
                answer[i]="Bronze Medal";
            }
            else{
                answer[i]=String.valueOf(rank);
            }
        }
        return answer;
    }
}