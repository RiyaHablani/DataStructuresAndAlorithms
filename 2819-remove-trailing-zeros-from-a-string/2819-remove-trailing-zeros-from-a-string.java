class Solution {
    public String removeTrailingZeros(String nums) {
        int n=nums.length();
        int i=n-1;
        StringBuilder str= new StringBuilder();
        while(i>=0){
            if(nums.charAt(i)=='0'){
                i--;
            }else{
               break;
            }
        }
        while(i>=0){
            str.append(nums.charAt(i));
            i--;
        }
        return str.reverse().toString();
    }
}