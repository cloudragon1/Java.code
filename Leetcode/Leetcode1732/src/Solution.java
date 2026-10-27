class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int h = 0;
        for (int d : gain) {
            h += d;
            ans = Math.max(ans, h);
        }
        return ans;
    }
}