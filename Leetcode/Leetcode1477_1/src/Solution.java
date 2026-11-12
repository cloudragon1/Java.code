/* 滑动窗口方法 */
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int ans = n + 1;
        int[] preMin = new int[n + 1];
        preMin[0] = n + 1;
        int minLen = n + 1;
        int sum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                ans = Math.min(ans, preMin[l] + r - l + 1);
                minLen = Math.min(minLen, r - l + 1);
            }
            preMin[r + 1] = minLen;
        }
        return ans > n ? -1 : ans;
    }
}