class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // counts of 'c', 'r', 'o', 'a', 'k'
        int frogs = 0; // current active frogs croaking
        int maxFrogs = 0; // max frogs needed simultaneously
        
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                count[0]++;
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            } else if (ch == 'r') {
                if (count[1] < count[0]) {
                    count[1]++;
                } else {
                    return -1; // invalid sequence
                }
            } else if (ch == 'o') {
                if (count[2] < count[1]) {
                    count[2]++;
                } else {
                    return -1; // invalid sequence
                }
            } else if (ch == 'a') {
                if (count[3] < count[2]) {
                    count[3]++;
                } else {
                    return -1; // invalid sequence
                }
            } else if (ch == 'k') {
                if (count[4] < count[3]) {
                    count[4]++;
                    frogs--; // one frog has finished croaking
                } else {
                    return -1; // invalid sequence
                }
            } else {
                return -1; // invalid character
            }
        }
        
        // Check if all counts are equal, meaning all frogs finished croaking
        if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4]) {
            return maxFrogs;
        } else {
            return -1; // some frogs haven't finished croaking
        }
    }
}