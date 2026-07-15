class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pair = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int low = 0,high=potions.length-1;
            while(low<high){
                int mid=low+(high-low)/2;
                if((long)spells[i]*potions[mid]>=success){
                    high=mid;
                }
                else{
                    low=mid+1;
                }
            }
            if((long)spells[i]*potions[low]>=success){
                pair[i]=potions.length-low;
            }
        }
        return pair;
    }
}