class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //Converting String to array.....
        String str1[] = s1.split(" ");
        String str2[] = s2.split(" ");

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<str1.length;i++){
            map.put(str1[i],map.getOrDefault(str1[i],0)+1);
        }
        for(int i=0;i<str2.length;i++){
            map.put(str2[i],map.getOrDefault(str2[i],0)+1);
        }
        List<String> list = new ArrayList<>();

        for(String key:map.keySet()){
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        return list.toArray(new String[0]);//to convert a list of strings into a string array
    }
}