class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] diff = new int[n + 1];
        diff[0] = 1;
        diff[1] = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum > 0 && s.charAt(i) == '0'){
                diff[Math.min(i + minJump, n)]++;
                diff[Math.min(i + maxJump + 1, n)]--;
            }
        }
        return sum > 0 && s.charAt(n - 1) == '0';
    }
}