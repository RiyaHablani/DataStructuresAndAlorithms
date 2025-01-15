class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < amount.length; i++) {
            max.add(amount[i]);
        }

        int count = 0;
        while(max.peek() > 0) {
            int num1 = max.poll();
            int num2 = max.poll();
            num1--;
            num2--;
            max.add(num1);
            max.add(num2);
            count++;
        }
        
        return count;
    }
}