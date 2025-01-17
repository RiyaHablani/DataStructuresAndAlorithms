class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int n=a.length(),m=b.length();
        int carry=0;
        int i=n-1,j=m-1;
        while(i>=0 || j>=0 || carry!=0 ){
            int bitA,bitB;
            if(i>=0){
                bitA=a.charAt(i)-'0';
            }else{
                bitA=0;
            }
            if(j>=0){
                bitB=b.charAt(j)-'0';
            }else{
                bitB=0;
            }
             i--;
             j--;
            int sum=bitA+bitB+carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        return sb.reverse().toString();
    }
}