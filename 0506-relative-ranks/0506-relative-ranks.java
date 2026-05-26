class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,score[i]);
        }
        int arr[]=new int[max+1];
        for(int i=0;i<n;i++){
            arr[score[i]]=i+1;
        }
        String res[]=new String[n];
        int rank=1;
        for(int i=max;i>=0;i--){
            if(arr[i]!=0){
            int originalIndex=arr[i]-1;
            if(rank==1){
                res[originalIndex]="Gold Medal";
            }else if(rank==2){
                res[originalIndex]="Silver Medal";
            }else if(rank==3){
                res[originalIndex]="Bronze Medal";
            }else{
                res[originalIndex]=Integer.toString(rank);
            }
            rank++;
            }
            if(rank>n) break;
        }
        return res;
    }
}