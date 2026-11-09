class Solution {
    private static final int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        int total = 0;
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int others = (total - f[c] + MOD) % MOD;
            f[c] = 1 + total;
            total = (f[c] + others) % MOD;
        }
        return total;
    }
}