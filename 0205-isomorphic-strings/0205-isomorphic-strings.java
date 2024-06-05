class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char a =t.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,a);
            }else{
                if(!map1.get(ch).equals(a)){
                    return false;
                }
            }if(!map2.containsKey(a)){
                map2.put(a,ch);
            }else{
                if(!map2.get(a).equals(ch)){
                    return false;
                }
            }
        }
        return true;
    }
}