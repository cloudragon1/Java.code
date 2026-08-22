class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0, m = 1;
        for (int i = n; i > 0; i /= 10) {
            int d = i % 10;
            s += d;
            m *= d;
        }
        return n % (s + m) == 0;
    }
}