class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sent = sentence.split(" ");
        for(int i = 0; i < sent.length; i++) {
            if(sent[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}