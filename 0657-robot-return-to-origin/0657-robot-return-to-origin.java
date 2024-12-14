class Solution {
    public boolean judgeCircle(String moves) {
        List<Character>list=new ArrayList<>();
        int i=0;
        while(i<=moves.length()-1){
            char ch=moves.charAt(i);
            if(ch=='L' && list.contains('R')){
                list.remove((Character)'R');
            }else if(ch=='R' && list.contains('L')){
                list.remove((Character)'L');
            }else if(ch=='U' && list.contains('D')){
                list.remove((Character)'D');
            }else if(ch=='D' && list.contains('U')){
                list.remove((Character)'U');
            }else{
                list.add(ch);
            }
            i++;
        }
        return list.isEmpty();
    }
}