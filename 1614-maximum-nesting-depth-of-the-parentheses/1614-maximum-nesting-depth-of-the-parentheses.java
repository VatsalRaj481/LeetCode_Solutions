class Solution {
    public int maxDepth(String s) {
        int depth=0,current=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                current++;
            }
            else if(c==')'){
                current--;
            }
            depth=Math.max(depth,current);
        }
        return depth;
    }
}