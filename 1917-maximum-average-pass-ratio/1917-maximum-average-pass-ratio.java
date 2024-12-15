class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store gain in decreasing order
        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double totalSum = 0;

        // Add initial values to the heap and calculate the total sum of current ratios
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double currentRatio = (double) pass / total;
            double gain = ((double) (pass + 1) / (total + 1)) - currentRatio;
            totalSum += currentRatio;
            heap.add(new double[]{gain, pass, total});
        }

        // Allocate extra students to maximize the average ratio
        while (extraStudents-- > 0) {
            double[] top = heap.poll();
            int pass = (int) top[1], total = (int) top[2];

            // Update sum for the new ratio
            totalSum -= (double) pass / total;
            pass++;
            total++;
            totalSum += (double) pass / total;

            // Calculate new gain and add it back to the heap
            double newGain = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
            heap.add(new double[]{newGain, pass, total});
        }

        // Return the final average
        return totalSum / classes.length;
    }
}