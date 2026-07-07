class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1;
        int max=0;
        while(start<end)
        {
            max=Math.max((end-start)*Math.min(height[end],height[start]),max);
            if(height[start]<height[end])
            {
                start++;
            }
            else{
                end--;
            }
        }
        return max;
    }
}