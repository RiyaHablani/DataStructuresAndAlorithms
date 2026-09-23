class Solution {
    public boolean lemonadeChange(int[] bills) {
        int doll5 = 0;
        int doll10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                // Customer gives $5
                // We don't need to give change
                doll5++;
            } 
            else if (bills[i] == 10) {
                // Customer needs $5 change
                if (doll5 == 0) {
                    return false;
                }
                doll5--;
                doll10++;
            } 
            else { // bills[i] == 20
                // Need $15 change
                // First preference:
                // Give one $10 and one $5
                if (doll10 > 0 && doll5 > 0) {
                    doll10--;
                    doll5--;
                } 
                // Otherwise give three $5
                else if (doll5 >= 3) {
                    doll5 -= 3;
                } 
                else {
                    // Cannot give $15 change
                    return false;
                }
            }
        }
        return true;
    }
}