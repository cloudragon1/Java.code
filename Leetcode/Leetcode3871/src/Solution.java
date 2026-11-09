class Solution {
    public long countCommas(long n) {
        long ans = 0;
        for (long low = 1000; low <= n; low *= 1000) {
            ans += n - low + 1;
        }
        return ans;
    }
}