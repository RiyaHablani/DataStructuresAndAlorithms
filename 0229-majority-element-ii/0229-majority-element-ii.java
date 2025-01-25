class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int freq[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > n / 3) {
                list.add(i);
            }
        }

        return list;
    }
}
