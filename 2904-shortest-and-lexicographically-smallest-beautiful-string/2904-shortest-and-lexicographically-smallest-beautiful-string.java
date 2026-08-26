class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int one=0;
        String ans="";
        int start=0;
        for(int end=0;end<n;end++){
            char c =s.charAt(end);
            if(c=='1'){
                one++;
            }
            while(one>k){
                if(s.charAt(start)=='1'){
                    one--;
                }
                start++;
            }
            if(one==k){
                while(s.charAt(start)=='0'){
                    start++;
                }
                String curr = s.substring(start,end+1);
                if(ans.equals("")
                ||curr.length()<ans.length()
                ||(curr.length()==ans.length() && curr.compareTo(ans)<0)){
                    ans=curr;
                }
            }
        }
        return ans;
    }
}