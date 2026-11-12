class Solution {
    public int maxPalindromes(String S, int k) {
        char[] s =  S.toCharArray();
        int n = s.length;
        int[] f = new int[n + 1];
        for (int i = k; i <= n; i++) {
            f[i] = f[i - 1];
            if (isPalindrome(s, i - k, i - 1)) f[i] = Math.max(f[i], f[i - k] + 1);
            if (i > k && isPalindrome(s, i - k - 1, i - 1)) f[i] = Math.max(f[i], f[i - k - 1] + 1);
        }
        return f[n];
    }
    private boolean isPalindrome(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}