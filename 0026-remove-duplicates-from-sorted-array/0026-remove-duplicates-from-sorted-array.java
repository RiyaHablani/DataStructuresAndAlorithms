class Solution {
    public int removeDuplicates(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int k=set.size();
        int j=0;
        for(int x:set){
            arr[j++]=x;
        }
        return k;
    }  
}