class Solution {
    public String reverseVowels(String s) {
        int low=0,high=s.length()-1;
        char[] chars=s.toCharArray();
        while(low<high)
        {
            char c1=chars[low],c2=chars[high];
            while(low<high && !isVowel(c1))
            {
                c1=chars[++low];
            }
            while(low<high && !isVowel(c2))
            {
                c2=chars[--high];
            }
            char temp=chars[low];
            chars[low]=chars[high];
            chars[high]=temp;
            low++;
            high--;
        }
        return new String(chars);
    }
    static boolean isVowel(char c)
    {
        char ch = Character.toLowerCase(c);
        switch(ch)
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}