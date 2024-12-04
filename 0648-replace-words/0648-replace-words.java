class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] word = sentence.split(" ");
        for (int i = 0; i < dictionary.size(); i++) {
            for (int j = 0; j < word.length; j++) {
                if (word[j].startsWith(dictionary.get(i))) {
                    word[j] = dictionary.get(i);
                }
            }
        }
        String value="";
        for(String res : word){
            value+=res+" ";
        }
        return value.trim();
    }
}