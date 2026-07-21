class Solution {
    public int binaryGap(int n) {
        String N = Integer.toBinaryString(n);
        if (Integer.bitCount(n) == 1){
            return 0;
        }
        char[] N1 = N.toCharArray();
        int max = 0;
        int last = -1;

        for (int i = 0; i < N1.length; i++) {
            if (N1[i] == '1') {
                if (last != -1) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
}