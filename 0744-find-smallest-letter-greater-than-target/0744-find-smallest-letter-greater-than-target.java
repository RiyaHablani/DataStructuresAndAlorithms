class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        char ans='$';
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
                ans=letters[mid];
            }
        }
        return (ans == '$') ? letters[0] : ans;
    }
}