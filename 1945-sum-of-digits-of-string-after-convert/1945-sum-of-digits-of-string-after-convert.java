class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        // convert characters to numbers
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            sb.append(val);
        }
        String str = sb.toString();
        // perform k transformations
        while (k-- > 0) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            str = String.valueOf(sum);
        }
        return Integer.parseInt(str);
    }
}