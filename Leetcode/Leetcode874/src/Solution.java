import java.util.HashSet;

class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Integer> obstacleSet = new HashSet<>(obstacles.length, 1);
        final int OFFSET = (int) 3e4;
        for (int[] obstacle : obstacles) {
            obstacleSet.add((obstacle[0] + OFFSET) << 16 | (obstacle[1] + OFFSET));
        }

        int x = 0, y = 0, k = 0, ans = 0;
        for (int c : commands) {
            if (c < 0) {
                k = (k + c * 2 + 7) % 4;
                continue;
            }
            while (c-- > 0) {
                int nx = x + DIRS[k][0];
                int ny = y + DIRS[k][1];
                if (obstacleSet.contains((nx + OFFSET) << 16 | (ny + OFFSET))) {
                    break;
                }
                x = nx;
                y = ny;
            }
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }
}