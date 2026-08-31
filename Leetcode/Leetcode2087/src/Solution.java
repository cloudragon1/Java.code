class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x0 = startPos[0], y0 = startPos[1];
        int x1 = homePos[0], y1 = homePos[1];
        int ans = -rowCosts[x0] - colCosts[y0];

        int l1 = Math.min(x0,x1), r1 = Math.max(x0, x1);
        for (int i = l1; i <= r1; i++) {
            ans += rowCosts[i];
        }

        int l2 = Math.min(y0,y1), r2 = Math.max(y0, y1);
        for (int i = l2; i <= r2; i++) {
            ans += colCosts[i];
        }
        return ans;
    }
}