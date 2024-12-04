class Solution {
    public boolean isBalanced(String num) {
        int countEven=0,countOdd=0;
        for(int i=0;i<num.length();i=i+2){
            countEven+=num.charAt(i)-'0';
        }for(int i=1;i<num.length();i=i+2){
            countOdd+=num.charAt(i)-'0';
        }
        return countEven==countOdd;
    }
}