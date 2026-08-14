import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 存入调用的方法
        List<Integer>[] list = new ArrayList[n];
        Arrays.setAll(list, i -> new ArrayList<>());
        for (int[] e : invocations) {
            list[e[0]].add(e[1]);
        }
        // 判断当前方法是否可疑
        boolean[] issuspicious = new boolean[n];
        dfs(k, list, issuspicious);
        for (int[] b : invocations) {
            if (!issuspicious[b[0]] && issuspicious[b[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        // 如果非可疑方法调用了可疑方法，则返回全部方法
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!issuspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    // 深度优先搜索可疑方法
    private void dfs(int x, List<Integer>[] list, boolean[] issuspicious){
        issuspicious[x] = true;
        for (int y : list[x]){
            if (!issuspicious[y]){
                dfs(y, list, issuspicious);
            }
        }
    }
}