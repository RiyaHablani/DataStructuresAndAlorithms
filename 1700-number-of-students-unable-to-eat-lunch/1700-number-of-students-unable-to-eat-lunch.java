class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleSandwich=0;
        int squareSandwich=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==0){
                circleSandwich++;
            }else{
                squareSandwich++;
            }
        }
        for(int i=0;i<sandwiches.length;i++){
            if(circleSandwich==0 && sandwiches[i]==0){
                return squareSandwich;
            }
            if(squareSandwich==0 && sandwiches[i]==1){
                return circleSandwich;
            }
            if(sandwiches[i]==0){
                circleSandwich--;
            }else{
                squareSandwich--;
            }
        }
        return 0;
    }
}