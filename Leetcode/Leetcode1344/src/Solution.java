class Solution {
    public double angleClock(int hour, int minutes) {
        double d = Math.abs(hour * 30 - minutes * 5.5);
        return Math.min(d, 360 - d);
    }
}