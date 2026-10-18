class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] f = new int[n];
        int[] sum = new int[n + 1];
        f[0] = sum[1] = 1;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && s.charAt(i) == '0' && sum[i - minJump + 1] > sum[Math.max(i - maxJump, 0)]){
                f[i] = 1;
            }
            sum[i + 1] = sum[i] + f[i];
        }
        return f[n - 1] == 1;
    }
}
