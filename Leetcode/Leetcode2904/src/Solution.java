class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replace("0", "").length() < k) {
            return "";
        }
        char[] S = s.toCharArray();
        String ans = s;
        int cnt = 0, left = 0;
        for (int right = 0; right < S.length; right++) {
            cnt += S[right] - '0';
            while (cnt > k || S[left] == '0') {
                cnt -= S[left++] - '0';
            }
            if (cnt == k) {
                String t = s.substring(left, right + 1);
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}