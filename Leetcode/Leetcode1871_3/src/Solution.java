class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] canReached = new boolean[n];
        canReached[0] = true;

        int j = 1;
        for (int i = 0; i < n && j < n; i++) {
            if (canReached[i] && s.charAt(i) == '0') {
                for (j = Math.max(j, i + minJump); j <= Math.min(i + maxJump, n - 1); j++) {
                    canReached[j] = true;
                }
            }
        }
        return canReached[n - 1] && s.charAt(n - 1) == '0';
    }
}