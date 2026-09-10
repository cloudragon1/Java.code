class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long f = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i]; // 计算 F(0)
            sum += nums[i]; // 计算 nums 的总和
        }

        long ans = f;
        for (int i = n - 1; i > 0; i--) {
            f += sum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return (int) ans;
    }
}