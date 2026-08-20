class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1= new ArrayList<>();
        List<Integer> arr2= new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            int num=nums[i];
            if(arr1.get(arr1.size()-1) >arr2.get(arr2.size()-1)){
                arr1.add(num);
            }
            else{
                arr2.add(num);
            }
        }
        int[] result = new int[nums.length];
        int i=0;
        for(int a:arr1){
            result[i++]=a;
        }
        for(int a:arr2){
            result[i++]=a;
        }
        return result;
    }
}