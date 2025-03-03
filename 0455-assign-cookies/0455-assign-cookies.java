class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int j=0,i=0,count=0;
        Arrays.sort(g);//7 8 9 10
        Arrays.sort(s);// 5 6 7 8
        while (i < g.length && j < s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}