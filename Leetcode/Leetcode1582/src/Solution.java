class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        next:
        for (int[] row : mat) {
            int col = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0){
                    continue;
                }
                if (col != -1){
                    continue next;
                }
                col = j;
            }
            if (col < 0){
                continue;
            }
            
            boolean seen1 = false;
            for (int[] r : mat) {
                if (r[col] == 0){
                    continue;
                }
                if (seen1){
                    continue next;
                }
                seen1 = true;
            }
            ans++;
        }
        return ans;
    }
}