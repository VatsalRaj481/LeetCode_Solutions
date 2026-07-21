class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int originalOnes=0;
        for(char c:s.toCharArray()){
            if(c=='1')originalOnes++;
        }
        String t='1'+s+'1';
        List<Character> type = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        int i=0;
        while(i<t.length()){
            char ch = t.charAt(i);
            int j=i;
            while(j<t.length() && t.charAt(j)==ch){
                j++;
            }
            type.add(ch);
            len.add(j-i);
            i=j;
        }

        int maxGain = 0;
        for(int k=1;k<type.size()-1;k++){
            if(type.get(k-1)=='0' && type.get(k)=='1' && type.get(k+1)=='0'){
                maxGain = Math.max(maxGain,len.get(k-1)+len.get(k+1));
            }
        }

        return originalOnes+maxGain;
    }
}