class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,n=fruits.length,maxLength=0;

        for (int right = 0; right < fruits.length; right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            if(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
                
            }
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}