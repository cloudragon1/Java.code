import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                a.add(nums[i]);
            } else if (nums[i] == pivot) {
                b.add(nums[i]);
            }else {
                c.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        for (Integer i : a) ans[idx++] = i;
        for (Integer i : b) ans[idx++] = i;
        for (Integer i : c) ans[idx++] = i;
        return ans;
    }
}