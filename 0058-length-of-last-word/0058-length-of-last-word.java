class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        // Split the string by spaces into words
        String[] words = s.split(" ");
        
        // Get the last word and return its length
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }
}