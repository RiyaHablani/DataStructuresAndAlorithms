class Solution {
    public String clearDigits(String s) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetter(ch)){
                ans.append(ch);
            }else{
                ans.deleteCharAt(ans.length()-1);
            }
        }
        return ans.toString();
    }
}