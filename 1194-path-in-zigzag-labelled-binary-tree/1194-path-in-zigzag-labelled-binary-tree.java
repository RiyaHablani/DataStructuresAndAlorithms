import java.util.*;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        int level = 0;
        int temp = label;

        // Find the level of the label
        while (temp > 0) {
            level++;
            temp /= 2;
        }

        // Traverse back to the root
        while (label > 0) {
            path.add(label);
            int levelStart = (int) Math.pow(2, level - 1);
            int levelEnd = (int) Math.pow(2, level) - 1;

            // Reverse the label if it's in a reversed level
            label = levelStart + levelEnd - label;

            // Move to the parent
            label /= 2;
            level--;
        }

        // Reverse the path to get root-to-label order
        Collections.reverse(path);
        return path;
    }
}
