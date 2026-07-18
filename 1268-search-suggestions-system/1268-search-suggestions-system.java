class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        String prefix="";
        for(char c:searchWord.toCharArray()){
            prefix+=c;
            int idx=lowerBound(products,prefix);
            List<String> list = new ArrayList<>();
            for(int i=idx;i<Math.min(idx+3,products.length);i++){
                if(products[i].startsWith(prefix)){
                    list.add(products[i]);
                }
                else{
                    break;
                }
            }
            ans.add(list);
        }
        return ans;
    }
    private int lowerBound(String[] products,String prefix){
        int low=0,high=products.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(products[mid].compareTo(prefix)<0){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}