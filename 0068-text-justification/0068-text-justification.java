class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result= new ArrayList<>();
        int i=0;

        while(i<words.length){
            int lineStart=i;
            int lineLen=words[i].length();
            i++;

            while(i<words.length && lineLen+1+words[i].length()<=maxWidth){
                lineLen+=1+words[i].length();
                i++;
            }
            int lineEnd=i-1;
            int wordCount=lineEnd-lineStart+1;
            boolean isLastLine=i==words.length;

            StringBuilder sb=new StringBuilder();

            if(isLastLine || wordCount==1){
                for(int j=lineStart;j<=lineEnd;j++){
                    sb.append(words[j]);
                    if(j!=lineEnd) sb.append(' ');
                }
                int remaining=maxWidth-sb.length();
                while(remaining-->0) sb.append(' ');
            }else{
                int totalWordLen=0;
                for(int j=lineStart;j<=lineEnd;j++) totalWordLen+=words[j].length();
                int totalSpaces=maxWidth-totalWordLen;
                int gaps=wordCount-1;
                int baseSpace=totalSpaces/gaps;
                int extra=totalSpaces%gaps;

                for(int j=lineStart;j<=lineEnd;j++){
                    sb.append(words[j]);
                    if(j!=lineEnd){
                        int spacesToInsert=baseSpace+(extra>0 ?1:0);
                        for(int s=0; s<spacesToInsert;s++) sb.append(' ');
                        if(extra>0) extra--;
                    }
                }
            }
            result.add(sb.toString());
        }       
        return result;
    }
}