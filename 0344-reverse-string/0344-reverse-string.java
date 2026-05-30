class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int n=s.length;
        int right=n;
        while(left<right){
            char temp=s[n-left-1];
            s[n-left-1]=s[left];
            s[left]=temp;
            left++;
            right--;
        }
    }
}