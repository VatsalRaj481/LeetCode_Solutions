class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();

        int currentNum = 0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                currentNum=currentNum*10+(ch-'0');
            }
            else if(ch=='['){
                countStack.push(currentNum);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                currentNum=0;
            }
            else if(ch==']'){
                int repeatTimes = countStack.pop();
                StringBuilder prevString = stringStack.pop();
                for(int i=0;i<repeatTimes;i++){
                    prevString.append(currentString);
                }
                currentString=prevString;
            }
            else{
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}