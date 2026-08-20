import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> seats = new HashMap<>();
        for (int[] r : reservedSeats) {
            int seat = r[1];
            if (2 <= seat && seat <= 9) {
                seats.merge(r[0], 1 << (seat - 2), (a, b) -> a | b);
            }
        }

        int emptyRows = n - seats.size();
        int ans = emptyRows * 2;

        for (Integer x : seats.values()) {
            if ((x & 0b1111) == 0 || (x & 0b111100) == 0 || (x & 0b11110000) == 0) {
            ans++;
            }
        }
        return ans;
    }
}