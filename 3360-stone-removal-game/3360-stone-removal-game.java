class Solution {
    public boolean canAliceWin(int n) {
        int removal=10;
        boolean aliceTurn=true;
        while(n>=removal){
            n-=removal;
            removal--;
            aliceTurn=!aliceTurn;
        }
        return !aliceTurn;
    }
}