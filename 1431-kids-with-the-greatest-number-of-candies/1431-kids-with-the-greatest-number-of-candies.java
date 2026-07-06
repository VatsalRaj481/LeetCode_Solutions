class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=candies[0];
        for(int candy:candies){
            if(candy>max) max=candy;
        }
        List<Boolean> result = new ArrayList<>();
        for(int i:candies){
            if(i+extraCandies>=max) result.add(true);
            else result.add(false);
        }
        return result;
    }
}