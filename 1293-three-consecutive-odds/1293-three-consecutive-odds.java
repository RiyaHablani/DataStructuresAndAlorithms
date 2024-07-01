class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<=arr.length-2;j++){
                if(arr[i]%2==1 && arr[j]%2==1 && arr[j+1]%2==1){
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}