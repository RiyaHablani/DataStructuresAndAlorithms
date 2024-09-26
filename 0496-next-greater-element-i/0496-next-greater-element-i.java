public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack= new Stack<>();
        int nums[]= new int[nums1.length];
        Arrays.fill(nums,-1);
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && (nums2[stack.peek()]<nums2[i])){
                int index=stack.pop();
                for(int j=0;j<nums1.length;j++){
                    if(nums1[j]==nums2[index]){
                        nums[j]=nums2[i];
                    }
                }
            }
            stack.push(i);
        }
        return nums;
    }
}