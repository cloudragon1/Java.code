class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        int right = n;
        while (right > 0 && sum + nums[right - 1] <= x) {
            right--;
            sum += nums[right];
        }
        if (right == 0 && sum < x) {
            return -1;
        }
        int ans = sum == x ? n - right : n + 1;
        for (int left = 0; left < n; left++) {
            sum += nums[left];
            while (right < n && sum > x) {
                sum -= nums[right];
                right++;
            }
            if (sum > x) {
                break;
            }
            if (sum == x) {
                ans = Math.min(ans, left + 1 + n - right);
            }
        }
        return ans > n ? -1 : ans;
    }
}