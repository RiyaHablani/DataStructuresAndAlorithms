class Solution {
    public int maxArea(int[] height) {
        int str=0,last=height.length-1,max=0;
        while(str<last){
            if(height[str]<height[last]){
                max=Math.max((last-str)*height[str],max);
                str++;
            }else{
                max=Math.max((last-str)*height[last],max);
                last--;
            }
        }
        return max;
    }
}