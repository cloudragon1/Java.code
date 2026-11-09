class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }
        int kinds = 0;
        int singles = 0;
        int nonZeros = 0;
        for (int d = 0; d < 10; d++) {
            if (cnt[d] == 0) continue;
            kinds++;
            if (d > 0) {
                nonZeros++;
                if (cnt[d] == 1) singles++;
            }
        }
        int ans = 0;
        for (int d = 0; d < 10; d += 2) {
            int c = cnt[d];
            if (c == 0) {
                continue;
            }
            int k = kinds;
            if (c == 1) {
                k--;
            }
            int nz = nonZeros;
            if (d > 0 && c == 1) {
                nz--;
            }
            int s = singles;
            if (d > 0) {
                if (c == 1) {
                    s--;
                } else if (c == 2) {
                    s++;
                }
            }
            ans += k * nz - s;
        }
        return ans;
    }
}