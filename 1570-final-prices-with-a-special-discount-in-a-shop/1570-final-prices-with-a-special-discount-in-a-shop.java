class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<prices.length;i++){
            s.push(prices[i]);
        }
        for(int i=0;i<prices.length;i++){
            if(s.peek()>nums[i]){
                st.push(s.pop());
            }
        }
    }
}
