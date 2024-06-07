class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int freq1[]=new int[256];
        int freq2[]=new int[256];
        int sum = 0, length = 0;
        
        int j=0;
        for (int i = 0; i < s.length();i++) {
            sum+=Math.abs(s.charAt(i)-t.charAt(i));
            while(sum>maxCost){
                sum -= Math.abs(s.charAt(j) - t.charAt(j));
                j++;
            }
            length = Math.max(length, i - j + 1);
        }
        
        return length;
    }
}