class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0,j=0;
        if(str2.length()>str1.length()) return false;
        while(i<str1.length() && j<str2.length()){
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);

            if(ch1==ch2 ||(ch1+1-'a')%26==(ch2-'a')%26){
                j++;
            }
            i++;
        }
        return j==str2.length();
    }
}