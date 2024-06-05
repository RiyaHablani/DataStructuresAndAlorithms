class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            int k = 0; 
            boolean match = true; 
            for (int j = 0; j < queries[i].length(); j++) {
                char ch = queries[i].charAt(j);
                if (k < pattern.length() && ch == pattern.charAt(k)) {
                    k++; 
                } else if (Character.isUpperCase(ch)) {
                    match = false; 
                    break; 
                }
            }
            if (k != pattern.length()) {
                match = false;
            }
            
            ans.add(match);
        }
        
        return ans;
    }
}