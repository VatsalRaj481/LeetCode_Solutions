class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> pair:knowledge){
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                int start=i,end=i;
                while(s.charAt(end)!=')'){
                    end++;
                }
                String key = s.substring(start+1,end);
                sb.append(map.getOrDefault(key,"?"));
                i=end;
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}