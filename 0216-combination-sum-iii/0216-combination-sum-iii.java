class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1,k,n,new ArrayList<>());
        return result;
    }
    private void backtrack(int start,int k,int remain,List<Integer> path){
        if(path.size()==k){
            if(remain==0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>remain) break;
            path.add(i);
            backtrack(i+1,k,remain-i,path);
            path.remove(path.size()-1);
        }
    }
}