class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] mn = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i : nums1) {
            mn[i & 1] = Math.min(mn[i & 1], i);
        }
        return mn[1] == Integer.MAX_VALUE || mn[1] < mn[0];
    }
}