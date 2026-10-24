class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (char w : words[i].toCharArray()) {
                sum += weights[w - 'a'];
            }
            ans[i] = (char) ('z' - sum % 26);
        }
        return new String(ans);
    }
}