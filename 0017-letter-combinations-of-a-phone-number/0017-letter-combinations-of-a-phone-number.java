class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
         if(digits.length()==0)
         {
            return result;
         }
         String[] map = {"","","abc","def","ghi","jkl","mno","pqrs"
         ,"tuv","wxyz"};
         generateCombinations(digits,0,map,"",result);
         return result;
    }
    private void generateCombinations(String digits,int index,String[] mapping,
    String current,List<String> result)
    {
        if(index==digits.length())
        {
            result.add(current);
            return;
        }
        String letters=mapping[digits.charAt(index)-'0'];
        for(char letter:letters.toCharArray())
        {
            generateCombinations(digits,index+1,mapping,current+letter,result);
        }
    }
}