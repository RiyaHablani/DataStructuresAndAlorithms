class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequency
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Create a priority queue (min-heap)
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int freqCompare = countMap.get(a) - countMap.get(b);
            if (freqCompare == 0) {
                return b.compareTo(a); // reverse lexicographical
            }
            return freqCompare;
        });

        // Step 3: Keep top k in the heap
        for (String word : countMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }

        // Step 4: Build result list
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        Collections.reverse(result); // since it's min-heap
        return result;
    }
}
