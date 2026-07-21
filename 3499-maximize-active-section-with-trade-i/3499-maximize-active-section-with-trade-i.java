// class Solution {
//     public int maxActiveSectionsAfterTrade(String s) {
//         int originalOnes=0;
//         for(char c:s.toCharArray()){
//             if(c=='1')originalOnes++;
//         }
//         String t='1'+s+'1';
//         List<Character> type = new ArrayList<>();
//         List<Integer> len = new ArrayList<>();
//         int i=0;
//         while(i<t.length()){
//             char ch = t.charAt(i);
//             int j=i;
//             while(j<t.length() && t.charAt(j)==ch){
//                 j++;
//             }
//             type.add(ch);
//             len.add(j-i);
//             i=j;
//         }

//         int maxGain = 0;
//         for(int k=1;k<type.size()-1;k++){
//             if(type.get(k-1)=='0' && type.get(k)=='1' && type.get(k+1)=='0'){
//                 maxGain = Math.max(maxGain,len.get(k-1)+len.get(k+1));
//             }
//         }

//         return originalOnes+maxGain;
//     }
// }

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes=0;
        int noOfzerosBeforeOne=0;
        int maxTransform=0;
        for(int i=0;i<s.length();i++){
            int noOfOnesBetweenZeros=0;
            while(i<s.length() && s.charAt(i)=='1'){
                noOfOnesBetweenZeros++;
                totalOnes++;
                i++;
            }

            int noOfZerosAfterOne=0;
            while(i<s.length() && s.charAt(i)=='0'){
                noOfZerosAfterOne++;
                i++;
            }

            if(noOfzerosBeforeOne>0 && noOfOnesBetweenZeros>0 && noOfZerosAfterOne>0){
                maxTransform=Math.max(maxTransform,
                noOfzerosBeforeOne+noOfZerosAfterOne);
            }
            noOfzerosBeforeOne=noOfZerosAfterOne;
            i--;

        }
        return totalOnes+maxTransform;
    }
}