class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            char tensPlace = details[i].charAt(11);
            char onesPlace = details[i].charAt(12);
            if (tensPlace > '6' || (tensPlace == '6' && onesPlace > '0')) {
                count++;
            }
        }
        return count;
    }
}