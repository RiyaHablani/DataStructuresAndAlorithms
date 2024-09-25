class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
