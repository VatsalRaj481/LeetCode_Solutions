class Solution {
    public int longestValidParentheses(String s) {
        int left=0,right=0,maxLen=0;

        //left->right
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')left++;
            else right++;

            if(left==right){
                maxLen=Math.max(maxLen,2*right);
            }
            else if(right>left) {
                left=right=0;
            }
        }

        //right to left 
        left=right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')left++;
            else right++;
            if(left==right){
                maxLen=Math.max(maxLen,2*left);
            }
            else if(left>right) left=right=0;
        }
        return maxLen;
    }
}

// Why two passes are needed
// Example: "(()"

// Left → Right:

// never gets equal counts → misses valid "()"

// Right → Left:

// catches it
// in short
// Left → Right catches:

// extra ) cases

// Right → Left catches:

// extra ( cases


// Stack approach

// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1); // base
        
//         int maxLen = 0;
        
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
            
//             if (c == '(') {
//                 stack.push(i);
//             } else {
//                 stack.pop();
                
//                 if (stack.isEmpty()) {
//                     stack.push(i); // reset base
//                 } else {
//                     maxLen = Math.max(maxLen, i - stack.peek());
//                 }
//             }
//         }
        
//         return maxLen;
//     }
// }