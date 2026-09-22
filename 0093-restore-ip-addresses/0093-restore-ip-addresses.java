class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> parts = new ArrayList<>();
        backtrack(s,0,parts,result);
        return result;
    }
    private void backtrack(String s,int index,List<String>parts,List<String> result){
        if(parts.size()==4){
            if(index==s.length()){
                result.add(String.join(".",parts));
            }
            return;
        }
        int remainingDigits = s.length()-index;
        int remainingParts = 4-parts.size();

        if(remainingDigits<remainingParts || remainingDigits>remainingParts*3){
            return;
        } 
        for(int len=1;len<=3 && index+len<=s.length();len++){
            String segment = s.substring(index,index+len);
            if(segment.length()>1 && segment.charAt(0)=='0')break;
            if(Integer.parseInt(segment)>255)break;
            parts.add(segment);
            backtrack(s,index+len,parts,result);
            parts.remove(parts.size()-1);

        }
    }
}