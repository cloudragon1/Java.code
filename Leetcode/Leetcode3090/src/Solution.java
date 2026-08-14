class Solution {
    public int maximumLengthSubstring(String s) {
        char[] S = s.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < S.length; i++) {
            int x = S[i] - 'a';
            cnt[x]++;
            while (cnt[x] > 2) {
                cnt[S[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}