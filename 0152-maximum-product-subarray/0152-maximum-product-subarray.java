class Solution {
    public int maxProduct(int[] arr) {
        int pref=1,suff=1,n=arr.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;

            pref*=arr[i];
            suff*=arr[n-i-1];

            ans=Math.max(ans,Math.max(pref,suff));
        }
        return ans;
    }
}
