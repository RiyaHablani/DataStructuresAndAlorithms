class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        String str1=strs[0];
        String str2=strs[strs.length-1];
        int i=0,j=0;
        while(i < str1.length() && i < str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                sb.append(str1.charAt(i));
                i++;
                j++;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}