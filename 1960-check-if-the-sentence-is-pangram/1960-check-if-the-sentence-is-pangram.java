class Solution {
    public boolean checkIfPangram(String sentence) {
        int freq[]= new int[26];
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            if (Character.isLowerCase(ch)) {
                freq[ch - 'a']++;
            } else if (Character.isUpperCase(ch)) {
                freq[ch - 'A']++;
            }
        }

        for(int i=0;i<26;i++){
            if(freq[i]==0){
                return false;
            }
        }
        return true;
    }
}