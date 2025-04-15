class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums1[i], i);
        }
        long total = 0;
        List<Integer> st = new ArrayList<>();
        for(int x : nums2){
            int idx = map.get(x);
            int left = orderOfKey(st, idx);
            int right = (n - 1 - idx) - (st.size() - left);
            total += (long) left * right;
            int pos = Collections.binarySearch(st, idx);
            if(pos < 0 ){
                pos = -pos - 1;
                st.add(pos,idx);
            }
        }
        return total;
    }

    private int orderOfKey(List<Integer> st, int key){
        int pos = Collections.binarySearch(st, key);
        return pos < 0 ? -pos - 1 : pos;
    }
}
