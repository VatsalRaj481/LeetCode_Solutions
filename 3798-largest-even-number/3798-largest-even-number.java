class Solution {
    public String largestEven(String s) {
        int lastTwo = s.lastIndexOf('2');
        return lastTwo==-1?"":s.substring(0,lastTwo+1);
    }
}