class Solution {
    public int largestInteger(int num) {
       PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>((a,b)->b-a);
        
        // Convert the number to a string to easily access each digit
        String numStr = String.valueOf(num);
                                 
        // Store the digits in the respective heaps based on whether they are even or odd
        for (char ch : numStr.toCharArray()) {
            int digit = ch - '0'; // Convert the character to an integer digit
            if (digit % 2 == 0) { // If the digit is even
                evenMaxHeap.add(digit); // Add to even heap
            } else { // If the digit is odd
                oddMaxHeap.add(digit); // Add to odd heap
            }
        }
        
        // StringBuilder to build the result number
        StringBuilder result = new StringBuilder();
        
        // Construct the largest integer by replacing digits with the largest available from heaps
        for (char ch : numStr.toCharArray()) {
            int digit = ch - '0'; // Convert the character to an integer digit
            if (digit % 2 == 0) { // If the digit is even
                result.append(evenMaxHeap.poll()); // Get the largest even digit from the heap
            } else { // If the digit is odd
                result.append(oddMaxHeap.poll()); // Get the largest odd digit from the heap
            }
        }
        
        // Convert the result string back to an integer and return
        return Integer.parseInt(result.toString());
    }
}