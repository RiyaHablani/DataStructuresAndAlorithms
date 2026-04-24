class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int windowStart=0;
        int windowEnd=0;
        int freq[] =new int[26];
        int len=0,maxLen=Integer.MIN_VALUE;
        while(windowEnd<n){
            int index=s.charAt(windowEnd)-'a';
            freq[index]++;
            while(freq[index]>2){
                int leftIndex = s.charAt(windowStart) - 'a';
                freq[leftIndex]--;
                windowStart++;
            }
            len=windowEnd-windowStart+1;
            maxLen=Math.max(maxLen,len);
            windowEnd++;
        }
        return (maxLen==Integer.MIN_VALUE)?0:maxLen;
    }
}