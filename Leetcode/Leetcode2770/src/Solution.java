class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[n];
        int ans = dfs(n - 1, nums, target, memo);
        return ans < 0 ? -1 : ans;
    }

    private int dfs(int j, int[] nums, int target, int[] memo) {
        if (j == 0) {
            return 0;
        }
        if (memo[j] != 0) {
            return memo[j];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < j; i++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                res = Math.max(res, dfs(i, nums, target, memo) + 1);
            }
        }
        memo[j] = res;
        return res;
    }
}