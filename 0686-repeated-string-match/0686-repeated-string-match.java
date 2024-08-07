class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeatCount = (int) Math.ceil((double) b.length() / a.length());
        
        String repeatedA = a.repeat(repeatCount);
        if (repeatedA.contains(b)) {
            return repeatCount;
        }
        
        repeatedA = a.repeat(repeatCount + 1);
        if (repeatedA.contains(b)) {
            return repeatCount + 1;
        }
        
        return -1;
    }
}