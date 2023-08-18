class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            String str=words[i];
            boolean x=palindrome(str);
            if(x){
                return words[i];
            }
        }
        return "";
    }
    public boolean palindrome (String a){
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i)!=a.charAt(a.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}