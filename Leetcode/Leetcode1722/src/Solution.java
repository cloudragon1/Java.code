import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : allowedSwaps) {
            int i = e[0];
            int j = e[1];
            g[i].add(j);
            g[j].add(i);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                Map<Integer, Integer> diff = new HashMap<>();
                dfs(x, source, target, g, vis, diff);
                for (int c : diff.values()) {
                    ans += Math.abs(c);
                }
            }
        }
        return ans / 2;
    }

    public void dfs(int x, int[] source, int[] target, List<Integer>[] g, boolean[] vis, Map<Integer, Integer> diff) {
        vis[x] = true;
        diff.merge(source[x], 1, Integer::sum);
        diff.merge(target[x], -1, Integer::sum);
        for (Integer i : g[x]) {
            if (!vis[i]) {
                dfs(i, source, target, g, vis, diff);
            }
        }
    }
}