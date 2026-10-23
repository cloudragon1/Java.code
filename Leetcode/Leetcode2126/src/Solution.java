import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            if (mass >= asteroids[i]) {
                mass += asteroids[i];
            }else {
                return false;
            }
        }
        return true;
    }
}