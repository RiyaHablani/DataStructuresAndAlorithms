class Solution {
    public int findNonMinOrMax(int[] arr) {
        if(arr.length<=2)
          return -1;
    for(int turn=0; turn<arr.length-1; turn++){
       for(int j=0;j<arr.length-1-turn;j++){
          if(arr[j]>arr[j+1]){
            int temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
          }
       }
     }  
     return arr[1];   
    }
}