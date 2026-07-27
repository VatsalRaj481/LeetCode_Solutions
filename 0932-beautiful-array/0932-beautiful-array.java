class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while(result.size()<n){
            List<Integer> temp = new ArrayList<>();

            for(int x:result){
                if(2*x-1<=n){
                    temp.add(2*x-1);
                }
            }

            for(int x:result){
                if(2*x<=n){
                    temp.add(2*x);
                }
            }

            result=temp;
        }
         int[] arr = new int[result.size()];
         for(int i=0;i<arr.length;i++){
            arr[i]=result.get(i);
         }
         return arr;
    }
}