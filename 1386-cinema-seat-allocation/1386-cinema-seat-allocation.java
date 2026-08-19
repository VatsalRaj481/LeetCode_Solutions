class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> reserved = new HashMap<>();
        for(int[] seat:reservedSeats){
            reserved.computeIfAbsent(seat[0],k->new HashSet<>()).add(seat[1]);
        }
        int assigned = (n-reserved.size())*2;
        for(Set<Integer> seats:reserved.values()){
            boolean left = true; //2345
            boolean middle = true; //4567
            boolean right = true; //6789

            for(int seat:seats){
                if(seat>=2 && seat<=5)left=false;
                if(seat>=4 && seat<=7)middle=false;
                if(seat>=6 && seat<=9)right=false;
            }
            
            if(left && right){
                assigned+=2;
            }
            else if(left||middle||right)assigned+=1;
        }
        return assigned;
    }
}