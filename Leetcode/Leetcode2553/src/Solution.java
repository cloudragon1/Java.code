import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> target = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums[i]; j > 0 ; j /= 10) {
                target.add(j % 10);
            }
        }
        int m = target.size();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = target.get(m - i - 1);
        }
        return ans;
    }
}