class Solution {
    public boolean judgeCircle(String moves) {
        int up=0,left=0;
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='U'){
                up++;
            }else if(ch=='D'){
                up--;
            }else if(ch=='L'){
                left++;
            }else if(ch=='R'){
                left--;
            }
        }
        return left==0 && up==0;
    }
}