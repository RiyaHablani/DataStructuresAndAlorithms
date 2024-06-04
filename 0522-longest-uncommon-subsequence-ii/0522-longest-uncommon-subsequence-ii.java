class Solution {
    public int findLUSlength(String[] strs) {
        int maxLength = -1;
        for(int i = 0; i< strs.length; i++){
            boolean isUncommon = true;
            for(int j = 0; j<strs.length; j++){
                if(i != j && isSubsequence(strs[i], strs[j])){
                    isUncommon = false;
                    break;
                }
            }
            if(isUncommon){
                maxLength = Math.max(maxLength, strs[i].length());
            }
        }
        return maxLength;
    }
    private boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}