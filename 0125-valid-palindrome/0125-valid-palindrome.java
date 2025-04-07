class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isUpperCase(ch) || Character.isLowerCase(ch) 
            || Character.isDigit(ch) ){
                sb.append(Character.toLowerCase(ch));
            }
        }
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}