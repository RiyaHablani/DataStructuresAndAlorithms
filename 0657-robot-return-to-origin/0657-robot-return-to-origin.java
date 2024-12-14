class Solution {
    public boolean judgeCircle(String moves) {
        int up=0,left=0;
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            switch(ch){
            case 'U':
               up++;
               break;
            case 'D':
               up--;
               break;
            case 'L':
               left++;
               break;
            case 'R':
               left--;
               break;
            }
        }
        return left==0 && up==0;
    }
}