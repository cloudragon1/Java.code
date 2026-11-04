class Solution {
    public int numberOfSubstrings(String s) {
        char[] S = s.toCharArray();
        int[] cnt = new int[3];
        int ans = 0;
        int left = 0;
        for (char c : S) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[S[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}