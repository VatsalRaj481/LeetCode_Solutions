class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a:asteroids)
        {
            boolean alive =true;

            while(alive && !stack.isEmpty() && stack.peek()>0 && a<0)
            {
                if(stack.peek()<-a)
                {
                    stack.pop();
                }
                else if(stack.peek()==-a)
                {
                    stack.pop();
                    alive=false;
                }
                else
                {
                    alive=false;
                }
            }
            if(alive)
            {
                stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}