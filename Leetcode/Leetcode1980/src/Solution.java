class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (char) (nums[i].charAt(i) ^ 1);
        }
        return new String(ans);
    }
}