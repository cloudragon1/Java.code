class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128];
        for (int right = 0; right < s.length; right++) {
            char c = s[right];
            while (has[c]) {
                has[s[left++]] = false;
            }
            has[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}