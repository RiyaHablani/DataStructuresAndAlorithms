class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int l=0;
        int n=height.length;
        int r=n-1;
        int ans=0;
        while(l<r){
            if(height[l]>leftMax){
                leftMax=Math.max(leftMax,height[l]);
            }
            if(height[r]>rightMax){
                rightMax=Math.max(rightMax,height[r]);
            }
            if(leftMax<rightMax){
                ans=ans+leftMax-height[l];
                l++;
            }
            else{
                ans=ans+rightMax-height[r];
                r--;
            }
        }
        return ans;
    }
}