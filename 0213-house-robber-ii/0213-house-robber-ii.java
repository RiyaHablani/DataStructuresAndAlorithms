class Solution {
    public int rob1(int[] nums) {
        //TC:O(n),SC:O(1)
        int n=nums.length;
        if(n==1) return nums[0];

        int prev2=0;
        int prev1=nums[0];
        int ans=0;
        for(int index=2;index<=n;index++){
            int pick=nums[index-1]+prev2;
            int nonpick=0+prev1;
            ans=Math.max(pick,nonpick);

            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        int num1[]=new int[n-1];
        int num2[]=new int[n-1];
        int j=0,k=0;
        for(int i=0;i<n;i++){
           if(i!=0){
            num1[j]=nums[i];
            j++;
           }if(i!=n-1){
            num2[k]=nums[i];
            k++;
           }
        }
        return Math.max(rob1(num1),rob1(num2));
    }
}