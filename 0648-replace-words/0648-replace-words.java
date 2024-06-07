class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Sort the dictionary by length of the words (shortest first) using a lambda expression
        Collections.sort(dictionary, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Iterate over each word in the sentence
        for (String word : words) {
            String replacement = word;

            // Check each word against the dictionary
            for (String root : dictionary) {
                // If the word starts with the dictionary root
                if (word.startsWith(root)) {
                    // Replace the word with the root
                    replacement = root;
                    break;
                }
            }

            // Append the replaced word (or original word if no replacement) to the result
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(replacement);
        }

        return result.toString();
    }
}