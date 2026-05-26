class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set=new HashSet<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
                res+=2;
            }else{
                set.add(ch);
            }
        }
        if(set.size()>0) return res+1;
        return res;
    }
}