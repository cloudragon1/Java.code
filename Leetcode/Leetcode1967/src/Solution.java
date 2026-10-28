class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String string : patterns) {
            if (word.contains(string)) {
                ans++;
            }
        }
        return ans;
    }
}