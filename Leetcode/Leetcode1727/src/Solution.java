import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix[0].length;
        int[] height = new int[n];
        int ans = 0;

        for (int[] row : matrix) {
            for (int i = 0; i < n; i++) {
                if (row[i] == 0) {
                    height[i] = 0;
                } else {
                    height[i]++;
                }
            }

            int[] heights = height.clone();
            Arrays.sort(heights);

            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, (n - j) * heights[j]);
            }
        }
        return ans;
    }
}