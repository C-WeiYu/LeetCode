class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> hp = new HashMap<>();
        for(int num : nums1){
            hp.put(num,hp.getOrDefault(num,0)+1);
        }
        for(int num : nums2){
            if(hp.get(num) != null){
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0 ;
        for(int num : set){
            res[i] = num ;
            i += 1;
        }
        return res;        
    }
}
