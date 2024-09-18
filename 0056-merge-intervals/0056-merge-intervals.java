class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res= new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentLevel=intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(currentLevel[1]>=intervals[i][0]){
                currentLevel[1]=Math.max(currentLevel[1],intervals[i][1]);
            }else{
                res.add(currentLevel);
                currentLevel=intervals[i];
            }
        } 
        res.add(currentLevel);
        return res.toArray(new int[res.size()][]);
    }
}
