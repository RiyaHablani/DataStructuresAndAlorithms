class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int end=0,start=0,n=nums.length,res=0,odd=0,count=0;
        while(end<n){
            if(nums[end]%2==1){
                odd++;
                count=0;
            }
            while(odd==k){
                count++;  // it is counting still the subarray is nice (means it has odd numbers equal to k)
                if(nums[start]%2==1){
                    odd--;
                }
                start++;
            }
            res+=count; // will add the result here 
            end++;
        }
        return res;
    }
}