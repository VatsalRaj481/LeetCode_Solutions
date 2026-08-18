class Solution {
    public String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        List<String> result = new ArrayList<>();
        for(String word:words){
            String s = word.toLowerCase();
            int row=0;
            if(first.indexOf(s.charAt(0))>=0)row=1;
            else if(second.indexOf(s.charAt(0))>=0)row=2;
            else row=3;
            boolean valid=true;
            for(char ch:s.toCharArray()){
                if(row==1 && first.indexOf(ch)==-1){
                    valid = false;
                    break;
                }
                if(row==2 && second.indexOf(ch)==-1){
                    valid = false;
                    break;
                }
                if(row==3 && third.indexOf(ch)==-1){
                    valid = false;
                    break;
                }
            }
            if(valid)result.add(word);
        }
        return result.toArray(new String[0]);
    }
}