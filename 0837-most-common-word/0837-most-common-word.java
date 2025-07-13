import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert the paragraph to lowercase
        paragraph = paragraph.toLowerCase();

        // Replace all punctuation with space
        paragraph = paragraph.replaceAll("[^a-z]", " ");

        // Split the paragraph into words
        String[] words = paragraph.split("\\s+");

        // Create a set of banned words for quick lookup
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        // Count frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Find the word with the highest frequency
        String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}
