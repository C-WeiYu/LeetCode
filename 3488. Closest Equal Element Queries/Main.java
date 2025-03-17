class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>() ;
        for(int i = 0; i < n; i++){
            List<Integer> temp = map.getOrDefault(nums[i], new ArrayList<>());
            temp.add(i);
            map.put(nums[i], temp);
        }
        
        for(List<Integer> arr : map.values()){
            int m = arr.size();
            if(m == 1){
                nums[arr.get(0)] = -1;
                continue;
            }
            for(int i = 0; i < m; i++){
                int j = arr.get(i);
                int f = arr.get((i + 1) % m);
                int b = arr.get((i - 1 + m) % m);
                int forward = (j - f + n) % n ;
                forward = Math.min(forward, (n - forward));
                int backward = (j - b + n) % n;
                backward = Math.min(backward, (n - backward));
                nums[j] = Math.min(forward, backward);
            }
        }

        for(int q : queries){
            res.add(nums[q]);
        }
        return res;
    }
}
