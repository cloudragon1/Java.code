class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int c = colors[0];
        if (c != colors[n - 1]) {
            return n - 1;
        }

        int r = n - 2;
        while (c == colors[r]) {
            r--;
        }

        int l = 1;
        while (colors[l] == colors[n - 1]) {
            l++;
        }
        return Math.max(r, n - 1 - l);
    }
}