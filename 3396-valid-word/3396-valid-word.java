class Solution {
    public boolean isValid(String word) {
        int vowel = 0, consonant = 0;
        if (word.length() < 3) return false;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!Character.isLetterOrDigit(ch)) return false;

            char lowerCh = Character.toLowerCase(ch);
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                vowel++;
            } else if (Character.isLetter(ch)) {
                consonant++;
            }
        }

        return vowel > 0 && consonant > 0;
    }
}
