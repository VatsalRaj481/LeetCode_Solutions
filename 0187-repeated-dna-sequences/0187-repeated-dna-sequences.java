class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String sequence=s.substring(i,i+10);
            map.put(sequence,map.getOrDefault(sequence,0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}