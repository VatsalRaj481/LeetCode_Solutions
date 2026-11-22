class Solution {
    public boolean checkString(String s) {
        boolean flag=false; //b has appeared already
        for(char c:s.toCharArray()){
            if( c=='b')flag=true;
            else if(c=='a' && flag)return false;
        }
        return true;
    }
}