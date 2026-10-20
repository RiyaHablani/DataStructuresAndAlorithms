class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int answer = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() == words[j].length() + 1
                        && isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    boolean isPredecessor(String shorter, String longer) {
        int i = 0, j = 0;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == shorter.length();
    }
}