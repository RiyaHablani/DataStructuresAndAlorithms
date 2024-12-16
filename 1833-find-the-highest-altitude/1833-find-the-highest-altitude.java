class Solution {
    public int largestAltitude(int[] gain) {
        int height=0,max=Integer.MIN_VALUE;
        for(int i=0;i<gain.length;i++){
            height+=gain[i];
            max=Math.max(max,height);
        }
        if(max>0){
            return max;
        }
       return 0;
    }
}