class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans='$';
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }else{
                ans=letters[mid];
                end=mid-1;
            }
        }
        return (ans=='$') ? letters[0] :ans;
    }
}