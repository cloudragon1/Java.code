class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for (int k = 0; k <= n / 2; k++) {
            if (words[(startIndex - k + n) % n].equals(target) || words[(startIndex + k) % n].equals(target)) {
                return k;
            }
        }
        return -1;
    }
}