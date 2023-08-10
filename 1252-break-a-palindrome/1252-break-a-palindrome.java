class Solution {
    public String breakPalindrome(String palindrome) {
        // Code here
        if(palindrome.length() == 1)
            return "";
        
        char[] ch = palindrome.toCharArray(); 
        
        for(int i = 0; i < palindrome.length()/2; i++)
        {
            if(ch[i] != 'a')
            {
                ch[i] = 'a';
                break;
            }
            else if(i == palindrome.length()/2 - 1 && ch[i] == 'a')
                ch[ch.length -1] = 'b';
        }
        
        return new String(ch);
    }
}