class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        Map<Integer,Integer> map = new HashMap<>();
        int rank=1;
        for(int c:copy){
            if(!map.containsKey(c)){
                map.put(c,rank++);
            }   
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}