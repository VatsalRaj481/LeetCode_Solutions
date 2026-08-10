class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n];
        for(int[] t:trust){
            int a=t[0],b=t[1];
            score[a-1]--;
            score[b-1]++;
        }
        for(int i=0;i<n;i++){
            if(score[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}