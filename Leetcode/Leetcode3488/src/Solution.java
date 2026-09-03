import java.util.*;
/*
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int n = nums.length;
        for (List<Integer> p : indices.values()) {
            int i0 = p.get(0);
            p.add(0,p.get(p.size() - 1) - n);
            p.add(i0 + n);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int i : queries) {
            List<Integer> p = indices.get(nums[i]);

            if (p.size() == 3) {
                ans.add(-1);
            }else {
                int j = Collections.binarySearch(p, i);
                ans.add(Math.min(i - p.get(j - 1), p.get(j + 1) - i));
            }
        }
        return ans;
    }
}*/


class Solution {
    public List<Integer> solveQueries (int [] nums, int [] queries) {
        int n = nums.length;
        int [] left = new int [n];
        int [] right = new int [n];
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums [i];
            left [i] = last.getOrDefault (x, -1);
            if (left [i] >= 0) {
                right [left [i]] = i;
            }
            first.putIfAbsent (x, i);
            last.put (x, i);
        }
        List<Integer> ans = new ArrayList<>(queries.length);
        for (int i : queries) {
            int l = left[i] >= 0 ? left[i] : last.get(nums[i]) - n;
            if (i - l == n) {
                ans.add(-1);
            } else {
                int r = right[i] > 0 ? right[i] : first.get(nums[i]) + n;
                ans.add(Math.min(i - l, r - i));
            }
        }
        return ans;
    }
}