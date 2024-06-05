class Solution {
    public int countPrefixes(String[] words, String s) {
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      if (s.length() >= words[i].length() && s.substring(0, words[i].length()).equals(words[i])) {
        count++;
      }
}
return count;
    }
}