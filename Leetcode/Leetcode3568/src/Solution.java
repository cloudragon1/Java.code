import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private record Node(int x, int y, int e, int mask) {
    }
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][]idx = new int[m][n];
        int cntL = 0, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            String row = classroom[i];
            for (int j = 0; j < n; j++) {
                char b = row.charAt(j);
                if (b == 'L') {
                    idx[i][j] = 1 << cntL++;
                } else if (b == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        int u = 1 << cntL;
        boolean[][][][] vis = new boolean[m][n][energy + 1][u];
        vis[sx][sy][energy][0] = true;
        List<Node> q = new ArrayList<>();
        q.add(new Node(sx, sy, energy, 0));
        for (int ans = 0; !q.isEmpty(); ans++) {
            List<Node> tmp = q;
            q = new ArrayList<>();

            for (Node p : tmp) {
                if (p.mask == u - 1) {
                    return ans;
                }
                if (p.e == 0) {
                    continue;
                }
                for (int[] d : DIRS) {
                    int x = p.x + d[0], y = p.y + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && classroom[x].charAt(y) != 'X') {
                        int newE = classroom[x].charAt(y) == 'R' ? energy : p.e - 1;
                        int newMask = p.mask | idx[x][y];
                        if (!vis[x][y][newE][newMask]) {
                            vis[x][y][newE][newMask] = true;
                            q.add(new Node(x, y, newE, newMask));
                        }
                    }
                }
            }
        }
        return -1;
    }
}