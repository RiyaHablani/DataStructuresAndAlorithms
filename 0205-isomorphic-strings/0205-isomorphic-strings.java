class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        HashMap<Character,Character> map1= new HashMap<>();
        HashMap<Character,Character> map2= new HashMap<>();
        
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            if(!map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i),s2.charAt(i));
            }else{
                if(!map1.get(s1.charAt(i)).equals(s2.charAt(i))){
                    return false;
                }
            }
            if(!map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i),s1.charAt(i));
            }else{
                if(!map2.get(s2.charAt(i)).equals(s1.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}