class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cntR = 0;
        int cntL = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                cntR++;
            } else if (c == 'L') {
                cntL++;
            }
        }
        return Math.abs(cntR - cntL) + moves.length() - cntR - cntL;
    }
}