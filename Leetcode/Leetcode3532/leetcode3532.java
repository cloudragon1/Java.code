/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<Integer> breakpoint =new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (nums[i + 1] - nums[i] > maxDiff){
                breakpoint.add(i);
            }
        }
        boolean[] target = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            target[i] = binarySearch(breakpoint, q[0]) == binarySearch(breakpoint, q[1]);
        }
        return target;
    }
    private int binarySearch(List<Integer> breakpoint, int target) {
        int i = Collections.binarySearch(breakpoint, target);
        return i < 0 ? ~i : i;
    }
}*/

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] id = new int[n]; // 每个节点所在连通块的编号
        for (int i = 1; i < n; i++) {
            id[i] = id[i - 1];
            if (nums[i] - nums[i - 1] > maxDiff) {
                id[i]++; // 找到了一个新的连通块
            }
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            ans[i] = id[q[0]] == id[q[1]];
        }
        return ans;
    }
}