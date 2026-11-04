class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        for (int pow = 1; n > 0; n /= 10) {
            int d = n % 10;
            if (d > 0) {
                sum += d;
                x += d * pow;
                pow *= 10;
            }
        }
        return (long) sum * x;
    }
}