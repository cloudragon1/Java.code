/*
import java.util.Arrays;

class Solution {
    public int maxProduct(int n) {
        char[] s = String.valueOf(n).toCharArray();
        Arrays.sort(s);
        int m = s.length;
        return (s[m - 1] - '0') * (s[m - 2] - '0');
    }
}*/

class Solution {
    public int maxProduct(int n) {
        int[] map = new int[10];
        while (n != 0){
            map[n % 10]++;
            n /= 10;
        }

        int ans = 1;
        int count = 2;
        for (int i = 9; i >= 0 ; i--) {
            while (map[i] > 0 && count != 0) {
                ans *= i;
                map[i]--;
                count--;
            }
            if (count == 0) {
                break;
            }

        }
        return ans;
    }
}