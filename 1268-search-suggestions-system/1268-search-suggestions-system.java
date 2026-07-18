// class Solution {
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         List<List<String>> ans = new ArrayList<>();
//         Arrays.sort(products);
//         String prefix="";
//         for(char c:searchWord.toCharArray()){
//             prefix+=c;
//             int idx=lowerBound(products,prefix);
//             List<String> list = new ArrayList<>();
//             for(int i=idx;i<Math.min(idx+3,products.length);i++){
//                 if(products[i].startsWith(prefix)){
//                     list.add(products[i]);
//                 }
//                 else{
//                     break;
//                 }
//             }
//             ans.add(list);
//         }
//         return ans;
//     }
//     private int lowerBound(String[] products,String prefix){
//         int low=0,high=products.length;
//         while(low<high){
//             int mid = low+(high-low)/2;
//             if(products[mid].compareTo(prefix)<0){
//                 low=mid+1;
//             }
//             else{
//                 high=mid;
//             }
//         }
//         return low;
//     }
// }

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        // Build Trie
        for (String word : products) {

            TrieNode curr = root;

            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';

                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();

                curr = curr.children[idx];

                // Keep only first 3 suggestions
                if (curr.suggestions.size() < 3)
                    curr.suggestions.add(word);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        TrieNode curr = root;

        for (char ch : searchWord.toCharArray()) {

            if (curr != null)
                curr = curr.children[ch - 'a'];

            if (curr == null)
                ans.add(new ArrayList<>());
            else
                ans.add(curr.suggestions);
        }

        return ans;
    }
}