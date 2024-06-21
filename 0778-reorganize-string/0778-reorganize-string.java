class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        // Calculate frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Create a max-heap based on character frequency
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        pq.addAll(map.keySet());
        
        char[] result = new char[s.length()];
        int i = 0;
        
        // Build the reorganized string
        while (!pq.isEmpty()) {
            char key = pq.poll();
            int val = map.get(key);
            
            while (val > 0) {
                result[i] = key;
                val--;
                i += 2;
                
                if (i >= result.length) {
                    i = 1;
                }
            }
        }
        
        // Check if the reorganized string is valid
        for (int j = 0; j < result.length - 1; j++) {
            if (result[j] == result[j + 1]) {
                return "";
            }
        }
        
        return new String(result);
    }
}