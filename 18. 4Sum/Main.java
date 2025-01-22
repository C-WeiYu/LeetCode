class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    private List<List<Integer>> kSum(int[] nums, long target, int k, int start){
        List<List<Integer>> res = new ArrayList<>();
        long average = target / k ;
        if(nums[start] > average || nums[nums.length-1] < average){
            return res ;
        }
        if(k > 2){
            for(int i = start ; i < nums.length-k+1 ; i++){
                List<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    for(List<Integer> t : temp){
                        t.add(0,nums[i]);
                        res.add(t);
                    }
                }
                while(i < nums.length-1 && nums[i] == nums[i+1]){
                    i++ ;
                }
            }
        }
        else{
            return twoSum(nums, target, start);
        }

        return res ;
    }
    private List<List<Integer>> twoSum(int[] nums, long target, int start){
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length -1 ;
        while(l < r){
            if(nums[l] + nums[r] == target){
                List<Integer> temp = new ArrayList<> (Arrays.asList(nums[l],nums[r]));
                res.add(temp);
                while(l < r && nums[l] == nums[l+1]){
                    l += 1 ;
                }
                while(l < r && nums[r] == nums[r-1]){
                    r -= 1 ; 
                }
                l += 1 ;
                r -= 1 ;
            }
            else if(nums[l] + nums[r] > target){
                r -= 1 ;
            }
            else{
                l += 1 ;
            }
        }
        return res ;
    }
}
