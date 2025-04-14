class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, new ArrayList<>());
        return res;
    }
    private void backTracking(int k, int n, int start, List<Integer> list){
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= 9; i++){
            list.add(i);
            backTracking(k - 1, n - i, i + 1, list);
            list.removeLast();
        }
    }
}
