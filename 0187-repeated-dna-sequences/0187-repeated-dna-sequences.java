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

// class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {
//         Set<Integer> seen = new HashSet<>();
//         Set<String> repeated = new HashSet<>();
//         for(int start=0;start<=s.length()-10;start++){
//             int code=0;
//             for(int i=start;i<start+10;i++){
//                 char c = s.charAt(i);
//                 int value;
//                 if(c=='A')value=0;
//                 else if(c=='C')value=1;
//                 else if(c=='G')value=2;
//                 else value=3;

//                 code=(code<<2)|value;
//             }
//             if(!seen.add(code)){
//                 repeated.add(s.substring(start,start+10));
//             }
//         }
//         return new ArrayList<>(repeated);
//     }
// }