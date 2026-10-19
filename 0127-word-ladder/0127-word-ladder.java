class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int length = 1;
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return length;
                }

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }

                        chars[j] = ch;
                        String nextWord = new String(chars);

                        if (set.contains(nextWord)) {
                            queue.add(nextWord);
                            set.remove(nextWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            length++;
        }

        return 0;
    }
}