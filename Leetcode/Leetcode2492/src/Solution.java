class Solution {
    public int minScore(int n, int[][] roads) {
        ps = new int[n];
        ds = new int[n];
        for (int i = 0 ; i < n ; i++) {
            ps[i] = i;
            ds[i] = Integer.MAX_VALUE;
        }
        for (int[] r : roads) {
            int a = r[0] - 1, b = r[1] - 1, d = r[2];
            union(a, b, d);
        }
        return ds[0];
    }
    int[] ps;
    int[] ds;

    protected int find(int i) {
        return ps[i] == i ? i : (ps[i] = find(ps[i]));
    }
    protected void union(int i, int j, int d) {
        int pi = find(i), pj = find(j);
        if (pi > pj) {int t = pi; pi = pj; pj = t;}
        ps[pj] = pi;
        ds[pi] = Math.min(ds[pi], ds[pj]);
        ds[pi] = Math.min(ds[pi], d);
    }

}