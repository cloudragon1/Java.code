import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
            set.add(x);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = mn + 1; i < mx; i++) {
            if (!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}