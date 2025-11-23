class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] used =new boolean[nums1.length];
        for(int num:nums2){
            int left=0;
            int right=nums1.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums1[mid]<num) left=mid+1;
                else right=mid-1;
            }
            int pos=left;
            while(pos<nums1.length && nums1[pos]==num && used[pos]) pos++;

            if(pos<nums1.length && nums1[pos]==num){
                used[pos]=true;
                list.add(num);
            }
        }
        int [] ans=new int[list.size()];
        for(int i=0;i<list.size();i++) ans[i]=list.get(i);
        return ans;
    }
}