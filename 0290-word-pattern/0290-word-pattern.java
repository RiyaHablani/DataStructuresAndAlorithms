class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] v = s.split(" ");
        
        if(v.length != pattern.length()){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){ //pattern in hashmap
                if(!map.get(ch).equals(v[i])){
                    return false;
                }
            }
            else{
                if(set.contains(v[i])){
                    return false;
                }
                map.put(ch, v[i]);
                set.add(v[i]);
            }
        }
        return true;
    }
}
