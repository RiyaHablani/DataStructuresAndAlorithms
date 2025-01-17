class Solution {
    public String addBinary(String a, String b) {
        String reverseda="";
        String reversedb="";
        for(int i=a.length()-1;i>=0;i--){
            reverseda+=a.charAt(i);
        }
        for(int i=b.length()-1;i>=0;i--){
            reversedb+=b.charAt(i);
        }
        StringBuilder sb=new StringBuilder();
        int n=reverseda.length();
        int m=reversedb.length();
        int carry=0;
        for(int i=0;i<n || i<m || carry!=0;i++){
            int bitA,bitB;
            if(i<n){
                bitA=reverseda.charAt(i)-'0';
            }else{
                bitA=0;
            }
            if(i<m){
                bitB=reversedb.charAt(i)-'0';
            }else{
                bitB=0;
            }
            int sum = bitA + bitB + carry;
    
            sb.append(sum % 2);  
            carry = sum / 2; 
        }
        return sb.reverse().toString();
    }
}