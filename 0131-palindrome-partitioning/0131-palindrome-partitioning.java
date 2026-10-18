class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        backtrack(res,list,s,0);
        return res;
    }
    public void backtrack(List<List<String>> res,List<String> list,String s,int index){
        if(s.length()==index){
            res.add(new ArrayList<>(list));
        }else{
            for(int i=index+1;i<=s.length();i++){
                String currString=s.substring(index,i);
                if(isPalindrome(currString)){
                    list.add(currString);
                    backtrack(res,list,s,i);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}