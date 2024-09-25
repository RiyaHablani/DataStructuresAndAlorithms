class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128]; 
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, (a, b) -> {
            if (freq[b] != freq[a]) {
                return freq[b] - freq[a]; 
            } else {
                return a - b; 
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }
}