class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1, new ArrayList<>());
        return res;
    }
    private void backTracking(int n, int k, int start,List<Integer> list){
        if(k == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n - k + 1; i++){
            list.add(i);
            backTracking(n, k-1, i+1, list);
            list.removeLast();
        }
    }
}
