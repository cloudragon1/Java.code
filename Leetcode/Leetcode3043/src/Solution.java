import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr1) {
            while (x > 0 && set.add(x)) {
                x /= 10;
            }
        }
        int mx = 0;
        for (int y : arr2) {
            while (y > 0 && !set.contains(y)) {
                y /= 10;
            }
            mx = Math.max(mx, y);
        }
        return mx > 0 ? Integer.toString(mx).length() : 0;
    }
}