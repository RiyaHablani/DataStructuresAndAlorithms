class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int p = password.length();
        if(p<8) return false;  //POINT 1
        boolean lower= false;  
        boolean upper = false;
        boolean digit = false;
        boolean special = false;
        String specialChar="!@#$%^&*()-+";
        for(int i=0;i<p;i++){
            //POINT 3 
            if(Character.isLowerCase(password.charAt(i))) lower = true;
            else if(Character.isUpperCase(password.charAt(i))) upper=true;
            else if(Character.isDigit(password.charAt(i))) digit = true;
            else if(specialChar.contains(Character.toString(password.charAt(i)))) special = true;
            if(i>0){
                if(password.charAt(i)==password.charAt(i-1)) return false; //POINT 2
            }
        }
        return lower && upper && digit && special; //Point 4

    }
}