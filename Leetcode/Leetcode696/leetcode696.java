class Solution {
    public int countBinarySubstrings(String s) {
        char[] S = s.toCharArray();
        int n = s.length();
        int pre = 0;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cur++;
            if (i == n - 1 || S[i] != S[i + 1]) {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}