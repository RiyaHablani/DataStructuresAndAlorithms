class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) {
            return false;
        }if(A.length()==0 || B.length()==0){
            return false;
        }if(A.length()==0 && B.length()==0){
            return true;
        }
        for(int i=0;i<A.length();i++){
            if(rotateString(A,B,i)){
                return true;
            }
        }
        return false;
    }
    public boolean rotateString(String A,String B,int rotation){
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt((i+rotation)%B.length())){
                return false;
            }
        }
        return true;
    }
}