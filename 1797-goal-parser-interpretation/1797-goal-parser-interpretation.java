class Solution {
    public String interpret(String command) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G'){
                sb.append('G');
            }else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                sb.append('o');
            }else if(command.charAt(i)=='(' && command.charAt(i+1)=='a'&&
            command.charAt(i+2)=='l' && command.charAt(i+3)==')'){
                sb.append('a');
                sb.append('l');
            }
        }
        return sb.toString();
    }
}