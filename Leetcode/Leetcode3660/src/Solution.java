class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 0; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int[] ans = new int[n];
        int sufMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = preMax[i] <= sufMin ? preMax[i] : ans[i + 1];
            sufMin = Math.min(sufMin, nums[i]);
        }
        return ans;
    }
}