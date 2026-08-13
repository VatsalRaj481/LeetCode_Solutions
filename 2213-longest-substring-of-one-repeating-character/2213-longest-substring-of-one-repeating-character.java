class Solution {
    class Node {
        char leftChar;
        char rightChar;
        int leftLen;
        int rightLen;
        int maxLen;
        int length;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            leftLen = 1;
            rightLen = 1;
            maxLen = 1;
            length = 1;
        }
    }

    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];

        build(s, 0, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(0, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[0].maxLen;
        }

        return ans;
    }

    private void build(String s, int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(s.charAt(start));
            return;
        }

        int mid = start + (end - start) / 2;

        build(s, 2 * node + 1, start, mid);
        build(s, 2 * node + 2, mid + 1, end);

        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private void update(int node, int start, int end, int index, char c) {
        if (start == end) {
            tree[node] = new Node(c);
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node + 1, start, mid, index, c);
        } else {
            update(2 * node + 2, mid + 1, end, index, c);
        }

        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private Node merge(Node left, Node right) {
        Node result = new Node(left.leftChar);

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;
        result.length = left.length + right.length;
        result.leftLen = left.leftLen;
        result.rightLen = right.rightLen;
        result.maxLen = Math.max(left.maxLen, right.maxLen);

        if (left.rightChar == right.leftChar) {
            result.maxLen = Math.max(
                    result.maxLen,
                    left.rightLen + right.leftLen);

            if (left.leftLen == left.length) {
                result.leftLen = left.length + right.leftLen;
            }

            if (right.rightLen == right.length) {
                result.rightLen = right.length + left.rightLen;
            }
        }

        return result;
    }
}

//Initial attempt

// class Solution {
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         StringBuilder sb = new StringBuilder(s);
//         int len[] = new int[queryIndices.length];
//         for(int i=0;i<queryIndices.length;i++){
//             int index=queryIndices[i];
//             sb.setCharAt(index,queryCharacters.charAt(i));
//             len[i]=longestSubstring(sb.toString());
//         }
//         return len;
//     }
//     private int longestSubstring(String str){
//         int len=0,left=0;
//         for(int right=0;right<str.length();right++){
//             if(str.charAt(right)!=str.charAt(left)){
//                 left=right;
//             }
//             len=Math.max(len,right-left+1);
//         }
//         return len;
//     }
// }