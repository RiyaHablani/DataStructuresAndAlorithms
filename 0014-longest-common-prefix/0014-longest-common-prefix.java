class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i=0,j=0;
        StringBuilder sb= new StringBuilder();
        String s1=strs[0],s2=strs[strs.length-1];
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                sb.append(s1.charAt(i));
                i++;
                j++;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}