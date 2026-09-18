class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines=1,width=0;
        for(char c:s.toCharArray()){
            if(width+widths[c-'a']>100){
                width=0;
                lines++;
            }
            width+=widths[c-'a'];
        }
        return new int[]{lines,width};
    }
}