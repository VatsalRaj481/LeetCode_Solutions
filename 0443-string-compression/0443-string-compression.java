class Solution {
    public int compress(char[] chars) {
        int write=0,i=0;
        while(i<chars.length){
            char current = chars[i];
            int count=0;
            while(i<chars.length && chars[i]==current){
                count++;
                i++;
            }
            chars[write++]=current;
            if(count>1){
                String s = Integer.toString(count);
                for(int j=0;j<s.length();j++){
                    chars[write++]=s.charAt(j);
                }
            }
        }
        return write;
    }
}