class Solution {
    public int longestSubsequence(int[] nums) {
        boolean allIsZero = false;
        int xor = 0;
        for (int x : nums) {
            allIsZero = allIsZero || x != 0;
            xor ^= x;
        }
        if (!allIsZero) {
            return 0;
        }
        int ans = nums.length;
        if (xor == 0) {
            ans--;
        }
        return ans;
    }
}