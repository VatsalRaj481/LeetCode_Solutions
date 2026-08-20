class Solution {
    public boolean checkRecord(String s) {
        int absent=0;
        int late=0;
        for(char ch:s.toCharArray()){
            if(ch=='A'){
                absent++;
                late=0;
            }
            else if(ch=='L')late++;
            else{
                late=0;
            }
            if(absent>=2||late>=3)return false;

        }
        return true;
    }
}