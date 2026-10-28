import java.util.HashMap;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge((long) x, 1, Integer::sum);
        }

        Integer cnt1 = cnt.remove(1L);
        int ans = cnt1 != null ? (cnt1 - 1) | 1 : 0;

        for (Long l : cnt.keySet()) {
            int res = 0;
            while (cnt.getOrDefault(l, 0) >= 2) {
                res += 2;
                l *= l;
            }
            ans = Math.max(ans, res + (cnt.containsKey(l) ? 1 : -1));
        }
        return ans;
    }
}