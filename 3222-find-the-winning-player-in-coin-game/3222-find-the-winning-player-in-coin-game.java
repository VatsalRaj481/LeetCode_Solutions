class Solution {
    public String winningPlayer(int x, int y) {
        boolean aliceTurn=true;
        while(x>=1 && y>=4){
            x-=1;
            y-=4;
            aliceTurn=!aliceTurn;
        }
        return !aliceTurn?"Alice":"Bob";
    }
}