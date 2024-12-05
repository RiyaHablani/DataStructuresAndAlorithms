class Solution {
    public boolean checkRecord(String s) {
        int countA=0,countL=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='A'){
                countA++;
            }else if(i!=0 && (i-1)!=0 && ch=='L' && s.charAt(i-1)=='L' && s.charAt(i-2)=='L'){
                countL+=3;
            }
            System.out.println(countL);
            if(countA==2 || countL==3) return false;
        }
        return true;
    }
}