import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int ans = 0;
        int maxp = 0;
        for (int[] p : intervals) {
            if (p[1] > maxp) {
                maxp = p[1];
                ans++;
            }
        }
        return ans;
    }
}