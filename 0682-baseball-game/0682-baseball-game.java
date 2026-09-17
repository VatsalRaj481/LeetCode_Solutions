class Solution {
    public int calPoints(String[] operations) {
        List<Integer> result = new ArrayList<>();
        for(String c:operations){
            if(c.equals("+")){
                int prev1=result.get(result.size()-1);
                int prev2=result.get(result.size()-2);
                result.add(prev1+prev2);
            }
            else if(c.equals("D")){
                result.add(result.get(result.size()-1)*2);
            }
            else if(c.equals("C")){
                result.remove(result.size()-1);
            }
            else{
                result.add(Integer.parseInt(c));
            }
        }
        int sum=0;
        for(int score:result){
            sum+=score;
        }
        return sum;
    }
}