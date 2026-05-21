class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int count = 0;
        while (pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();
            long newVal = first * 2 + second;
            pq.offer(newVal);
            count++;
        }
        return count;
    }
}