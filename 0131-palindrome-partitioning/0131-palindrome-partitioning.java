class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        palindrome(0, s, new ArrayList<>(), result);
        return result;
    }

    private void palindrome(int indx, String s, List<String> ans, List<List<String>> result) {
        if (indx == s.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = indx; i < s.length(); i++) {
            if (isPalindrome(s, indx, i)) {
                ans.add(s.substring(indx, i + 1));
                palindrome(i + 1, s, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
