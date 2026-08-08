class Solution {
    public int minimumScore(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int n = s.length;
        int m = t.length;

        int[] suf = new int[n + 1];
        suf[n] = m;
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == t[j]) {
                j--;
            }
            if (j < 0) { // t 是 s 的子序列
                return 0;
            }
            suf[i] = j + 1;
        }

        int ans = suf[0]; // 删除 t[:suf[0]]
        j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == t[j]) { // 注意上面判断了 t 是 s 子序列的情况，这里 j 不会越界
                j++;
                ans = Math.min(ans, suf[i + 1] - j); // 删除 t[j:suf[i+1]]
            }
        }
        return ans;
    }
}