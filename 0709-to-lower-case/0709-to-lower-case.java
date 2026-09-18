class Solution {
    public String toLowerCase(String s) {
        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Character.toLowerCase(s.charAt(i));
        }
        return new String(arr);
    }
}