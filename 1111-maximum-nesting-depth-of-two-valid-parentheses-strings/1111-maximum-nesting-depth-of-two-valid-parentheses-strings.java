class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth=0;
        int[] answer = new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            char ch = seq.charAt(i);
            if(ch=='('){
                depth++;
                answer[i]=depth%2;
            }
            else{
                answer[i]=depth%2;
                depth--;
            }
        }
        return answer;
    }
}