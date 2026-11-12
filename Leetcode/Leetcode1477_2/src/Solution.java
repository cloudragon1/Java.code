/* 前后缀分解法 */
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] sufMin = new int[n];
        int minLen = n + 1;
        int sum = 0;
        int r = n - 1;
        for (int l = n - 1; l > 0; l--) {
            sum += arr[l];
            while (sum > target) {
                sum -= arr[r];
                r--;
            }
            if (sum == target) {
                minLen = Math.min(minLen, r - l + 1);
            }
            sufMin[l] = minLen;
        }
        int ans = n + 1;
        sum = 0;
        int l = 0;
        for (r = 0; r < n - 1; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                ans = Math.min(ans, sufMin[r + 1] + r - l + 1);
            }
        }
        return ans > n ? -1 : ans;
    }
}