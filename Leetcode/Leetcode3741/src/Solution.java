import java.util.Arrays;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(first, -n);
        Arrays.fill(second, -n);
        int ans = n;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            ans = Math.min(ans,i-second[val]);
            second[val] = first[val];
            first[val] = i;
        }
        return ans==n ? -1: 2*ans;
    }
}