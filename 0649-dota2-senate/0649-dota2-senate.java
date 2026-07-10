class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            char c=senate.charAt(i);
            if(c=='R'){
                radiant.offer(i);
            }
            else{
                dire.offer(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r=radiant.poll();
            int d=dire.poll();
            if(r<d){
                radiant.offer(r+n);
            }
            else{
                dire.offer(d+n);
            }
        }
        return !radiant.isEmpty()? "Radiant":"Dire";
    }
}