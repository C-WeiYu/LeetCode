class Solution {
    public int maxArea(int[] height) {
        int ans = 0 ;
        int l = 0 ;
        int r = height.length -1 ;
        while(l < r ){
            int temp = 0 ;
            if(height[l] < height[r]){
                temp = (r-l) * height[l];
                l += 1 ;
            }
            else{
                temp = (r-l) * height[r];
                r -= 1; 
            }
            ans = Math.max(temp, ans);
        }
        return ans ;
    }
}
