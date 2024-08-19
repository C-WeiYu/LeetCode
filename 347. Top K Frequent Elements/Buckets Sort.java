class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List[] buckets = new List[nums.length+1];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int num : map.keySet()){
            int count = map.get(num);
            if(buckets[count] == null){
                buckets[count] = new ArrayList<Integer> ();
            }
            buckets[count].add(num);
        }

        ArrayList<Integer> ans = new ArrayList<> ();
        for(int i = buckets.length-1 ; ans.size() < k ; i--){
            if(buckets[i] != null){
                ans.addAll(buckets[i]);
            }
        }
        int[] f_ans = new int[ans.size()];
        for(int i = 0 ; i < f_ans.length ; i++){
            f_ans[i] = ans.get(i);
        }
        return f_ans;

    }
}
