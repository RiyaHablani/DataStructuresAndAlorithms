class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        // Two fronts for bidirectional BFS
        Set<String> frontA = new HashSet<>();
        Set<String> frontB = new HashSet<>();
        frontA.add(beginWord);
        frontB.add(endWord);

        // Visited sets to avoid repeats
        Set<String> visitedA = new HashSet<>();
        Set<String> visitedB = new HashSet<>();
        visitedA.add(beginWord);
        visitedB.add(endWord);

        int steps = 1; // beginWord counts as level 1

        while (!frontA.isEmpty() && !frontB.isEmpty()) {
            // Always expand the smaller front
            if (frontA.size() > frontB.size()) {
                Set<String> tmp = frontA;
                frontA = frontB;
                frontB = tmp;

                Set<String> t2 = visitedA;
                visitedA = visitedB;
                visitedB = t2;
            }

            Set<String> next = new HashSet<>();

            for (String word : frontA) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        chars[i] = c;
                        String cand = new String(chars);

                        // If the other front has this word we met in the middle
                        if (frontB.contains(cand)) return steps + 1;

                        // If candidate is valid and new then add to next layer
                        if (dict.contains(cand) && !visitedA.contains(cand)) {
                            visitedA.add(cand);
                            next.add(cand);
                        }
                    }
                    chars[i] = old; // restore
                }
            }

            frontA = next;
            steps++;
        }

        return 0;
    }
}