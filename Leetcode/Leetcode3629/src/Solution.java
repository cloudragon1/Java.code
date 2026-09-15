class Solution {
    private static final int MX = 1_000_001;
    private static final List<Integer>[] primeFactors = new ArrayList[MX];
    private static boolean initialized = false;

    public Solution() {
        if (initialized) {
            return;
        }
        initialized = true;

        Arrays.setAll(primeFactors, _ -> new ArrayList<>());
        for (int i = 2; i < MX; i++) {
            if (primeFactors[i].isEmpty()) {
                for (int j = i; j < MX; j += i) {
                    primeFactors[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int p : primeFactors[nums[i]]) {
                groups.computeIfAbsent(p, _ -> new ArrayList<>()).add(i);
            }
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;
        List<Integer> q = List.of(0);

        for (int ans = 0; ; ans++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int i : tmp) {
                if (i == n - 1) {
                    return ans;
                }
                List<Integer> idx = groups.computeIfAbsent(nums[i], _ -> new ArrayList<>());
                idx.add(i + 1);
                if (i > 0) {
                    idx.add(i - 1);
                }
                for (int j : idx) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.add(j);
                    }
                }
                idx.clear();
            }
        }
    }
}