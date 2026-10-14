class Solution {
    public String longestPalindrome(String s) {
        int start=0,maxLength=0;
        for(int i=0;i<s.length();i++){
            //odd palindrome
            int left=i,right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>maxLength){
                maxLength=right-left-1;
                start=left+1;
            }
            //even palindrome
            left=i;
            right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>maxLength){
                maxLength=right-left-1;
                start=left+1;
            }
        }
        return s.substring(start,start+maxLength);
    }
}