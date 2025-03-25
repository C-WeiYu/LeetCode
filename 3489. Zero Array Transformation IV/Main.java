class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int p = queries.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            int[] dp = new int[num+1];
            dp[num] = 1;
            boolean found = false;
            for (int j = 0; j < p; j++) {
                int l = queries[j][0];
                int r = queries[j][1];
                int v = queries[j][2];
                if (l <= i && i <= r) {
                    for (int k = v; k <= num; k++) {
                        if (dp[k] == 1) {
                            dp[k-v] = 1;
                        }
                    }
                    if (dp[0] == 1) {
                        max = Math.max(max, j + 1);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                return -1;
            }
        }
        return max;
    }
}
